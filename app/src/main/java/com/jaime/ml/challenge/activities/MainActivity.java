package com.jaime.ml.challenge.activities;

/*-----------------------------------------------*/
/*					Author                       */
/*				Jaime Vallejo                    */
/*                                               */
/*				Fecha Creacion                   */
/*				  14/09/2020                     */
/*                                               */
/*				Descripcion                      */
/*   Proyecto creado como un Challenge de ML     */
/*   como proceso de selección                   */
/*-----------------------------------------------*/

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.BaseColumns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jaime.ml.challenge.R;
import com.jaime.ml.challenge.models.Suggestion;
import com.jaime.ml.challenge.tasks.SearchSuggestionsTask;
import com.jaime.ml.challenge.utils.ThemeUtils;
import com.jaime.ml.challenge.utils.Utilities;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Variable para SharedPreferences del Usuario
    private SharedPreferences mSharedPreferences;
    //Variable Cursor de las sugerencias de busqueda
    private CursorAdapter suggestionAdapter;
    //Variable que controla el toolbar
    private Toolbar toolbar;
    //Variable que creara un delay al momento de editar la barra de busqueda
    //El motivo por el cual se crea, es para evitar las multiples llamadas del query de busqueda,
    //sin tener que realizar mayores ajustes
    private Handler mHandler;
    //Controlar el darckTheme
    boolean mIsModeNight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configTheme();
        initializeVariables();
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            if (mIsModeNight) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                mIsModeNight = false;
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                mIsModeNight = true;
            }
            SharedPreferences.Editor editor = mSharedPreferences.edit();
            editor.putBoolean(ThemeUtils.SP_DARK_THEME, mIsModeNight);
            editor.apply();
        });

    }

    //Metodo que inicializa las variables
    private void initializeVariables() {
        mHandler = new Handler();
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        suggestionAdapter = new SimpleCursorAdapter(
                this,
                R.layout.search_view_suggestion_row,
                null,
                new String[]{SearchManager.SUGGEST_COLUMN_TEXT_1},
                new int[]{android.R.id.text1},
                0);
    }

    //Metodo que forza el tema debido a que al iniciar el activity se tiene el del SplashTheme
    //Consulta el SharedPreferences para validar el tema guardado por el usuario
    private void configTheme() {
        setTheme(R.style.MyTheme_DayNight);
        mSharedPreferences = getPreferences(MODE_PRIVATE);
        mIsModeNight = mSharedPreferences.getBoolean(ThemeUtils.SP_DARK_THEME, false);
        if (mIsModeNight) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; agrega los items de menu del main al actual toolbar.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem mSearchItem = menu.findItem(R.id.search_icon);

        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) mSearchItem.getActionView();
        ComponentName componentName = new ComponentName(this, MainActivity.class);
        AutoCompleteTextView searchAutoCompleteTextView = (AutoCompleteTextView) searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        searchAutoCompleteTextView.setThreshold(0);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName));
        searchView.setSuggestionsAdapter(suggestionAdapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.length() > 0) {
                    Suggestion suggestion = new Suggestion();
                    suggestion.setQuery(query);
                    suggestion.save();
                    goToListProductsResultsActivity(query);
                } else {
                    return false;
                }

                return true;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                mHandler.removeCallbacksAndMessages(null);

                if (query.length() > 0) {
                    mHandler.postDelayed(() -> new SearchSuggestionsTask(searchView).execute(query), 300);
                } else {
                    List<Suggestion> suggestions = SQLite
                            .select()
                            .from(Suggestion.class)
                            .queryList();
                    Utilities.loadSuggestionsSaved(searchView,suggestions);
                    return true;
                }

                return true;
            }
        });
        searchView.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
            @Override
            public boolean onSuggestionSelect(int position) {
                if (position > 0) {
                    Cursor cur = searchView.
                            getSuggestionsAdapter().
                            getCursor();
                    cur.moveToPosition(position);
                    String query = cur.getString(cur.getColumnIndex(BaseColumns._ID));
                    saveSuggestion(query);
                    goToListProductsResultsActivity(query);
                } else {
                    return false;
                }
                return true;
            }

            @Override
            public boolean onSuggestionClick(int position) {
                if (position >= 0) {
                    Cursor cur = searchView.
                            getSuggestionsAdapter().
                            getCursor();
                    cur.moveToPosition(position);
                    String query = cur.getString(cur.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_1));
                    saveSuggestion(query);
                    goToListProductsResultsActivity(query);
                } else {
                    return false;
                }
                return true;
            }
        });
        MenuItemCompat.setOnActionExpandListener(mSearchItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                // Llamada cuando SearchView se cierra
                if (mSearchItem.isActionViewExpanded()) {
                    animateSearchToolbar(1, false, false);
                }
                return true;
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                // Llamada cuando SearchView se abre
                animateSearchToolbar(1, true, true);
                return true;
            }
        });
        return true;
    }

    //Guardar la sugerencia
    private void saveSuggestion(String query){
        Suggestion suggestion = new Suggestion();
        suggestion.setQuery(query);
        try {
            suggestion.save();
        } catch (SQLiteConstraintException e) {
            e.printStackTrace();
        }
    }

    //Metodo que crea la animacion del SearchView y cambia el color del Toolbar
    public void animateSearchToolbar(int numberOfMenuIcon, boolean containsOverflow, boolean show) {

        if (mIsModeNight) {
            toolbar.setBackgroundColor(ContextCompat.getColor(this, android.R.color.black));
        } else {
            toolbar.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
        }

        if (show) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                @SuppressLint("PrivateResource") int width = toolbar.getWidth() -
                        (containsOverflow ? getResources().getDimensionPixelSize(R.dimen.abc_action_button_min_width_overflow_material) : 0) -
                        ((getResources().getDimensionPixelSize(R.dimen.abc_action_button_min_width_material) * numberOfMenuIcon) / 2);
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(toolbar,
                        isRtl(getResources()) ? toolbar.getWidth() - width : width, toolbar.getHeight() / 2, 0.0f, (float) width);
                createCircularReveal.setDuration(250);
                createCircularReveal.start();
            } else {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) (-toolbar.getHeight()), 0.0f);
                translateAnimation.setDuration(220);
                toolbar.clearAnimation();
                toolbar.startAnimation(translateAnimation);
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                @SuppressLint("PrivateResource") int width = toolbar.getWidth() -
                        (containsOverflow ? getResources().getDimensionPixelSize(R.dimen.abc_action_button_min_width_overflow_material) : 0) -
                        ((getResources().getDimensionPixelSize(R.dimen.abc_action_button_min_width_material) * numberOfMenuIcon) / 2);
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(toolbar,
                        isRtl(getResources()) ? toolbar.getWidth() - width : width, toolbar.getHeight() / 2, (float) width, 0.0f);
                createCircularReveal.setDuration(250);
                createCircularReveal.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        toolbar.setBackgroundColor(getThemeColor(MainActivity.this, R.attr.colorPrimary));
                    }
                });
                createCircularReveal.start();
            } else {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-toolbar.getHeight()));
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(alphaAnimation);
                animationSet.addAnimation(translateAnimation);
                animationSet.setDuration(220);
                animationSet.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        toolbar.setBackgroundColor(getThemeColor(MainActivity.this, R.attr.colorPrimary));
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                toolbar.startAnimation(animationSet);
            }
        }
    }

    private boolean isRtl(Resources resources) {
        return resources.getConfiguration().getLayoutDirection() == View.LAYOUT_DIRECTION_RTL;
    }

    private static int getThemeColor(Context context, int id) {
        Resources.Theme theme = context.getTheme();
        TypedArray a = theme.obtainStyledAttributes(new int[]{id});
        int result = a.getColor(0, 0);
        a.recycle();
        return result;
    }

    private void goToListProductsResultsActivity(String query) {
        Intent intent = new Intent(MainActivity.this, ListProductsActivity.class);
        intent.putExtra(Utilities.INTENT_QUERY_ID, query);
        startActivity(intent);
    }

}