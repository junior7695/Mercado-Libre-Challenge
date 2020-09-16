package com.jaime.ml.challenge.utils;

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

import android.app.SearchManager;
import android.database.MatrixCursor;
import android.provider.BaseColumns;

import androidx.appcompat.widget.SearchView;
import androidx.cursoradapter.widget.CursorAdapter;

import com.jaime.ml.challenge.models.Suggestion;

import java.util.ArrayList;
import java.util.List;

public class Utilities {

    public static final String INTENT_QUERY_ID = "query";

    public static void loadSuggestions(SearchView searchView, ArrayList<String> searchResponse) {

        String[] columns = {
                BaseColumns._ID,
                SearchManager.SUGGEST_COLUMN_TEXT_1,
                SearchManager.SUGGEST_COLUMN_INTENT_DATA
        };

        MatrixCursor cursor = new MatrixCursor(columns);

        for (int i = 0; i < searchResponse.size(); i++) {

            String[] tmp = {Integer.toString(i),  searchResponse.get(i), "COLUMNT_INTENT_DATA"};
            cursor.addRow(tmp);
        }
        CursorAdapter suggestionAdapter = searchView.getSuggestionsAdapter();
        suggestionAdapter.changeCursor(cursor);
    }

    public static void loadSuggestionsSaved(SearchView searchView, List<Suggestion> suggestions) {

        String[] columns = {
                BaseColumns._ID,
                SearchManager.SUGGEST_COLUMN_TEXT_1,
                SearchManager.SUGGEST_COLUMN_INTENT_DATA
        };

        MatrixCursor cursor = new MatrixCursor(columns);

        for (int i = 0; i < suggestions.size(); i++) {

            String[] tmp = {Integer.toString(i),
                    suggestions.get(i).getQuery(),
                    "COLUMNT_INTENT_DATA"};
            cursor.addRow(tmp);
        }
        CursorAdapter suggestionAdapter = searchView.getSuggestionsAdapter();
        suggestionAdapter.changeCursor(cursor);
    }
}
