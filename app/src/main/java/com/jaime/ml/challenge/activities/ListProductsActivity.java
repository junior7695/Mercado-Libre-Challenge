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

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.gson.Gson;
import com.jaime.ml.challenge.R;
import com.jaime.ml.challenge.adapters.ProductAdapter;
import com.jaime.ml.challenge.interfaces.OnItemClickListener;
import com.jaime.ml.challenge.models.ProductML;
import com.jaime.ml.challenge.utils.ApiUtils;
import com.jaime.ml.challenge.utils.Utilities;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListProductsActivity extends AppCompatActivity implements OnItemClickListener {

    //query de busqueda
    private String query;
    //adaptador para el reciclerView
    private ProductAdapter adapter;
    //variable que contiene el toolbar
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    //variable que contiene el reciclerview
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    //variable que contiene el shimmerFragment para ocultar
    //activar o detener la animacion
    @BindView(R.id.shimmer)
    ShimmerFrameLayout shimmer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_products);
        ButterKnife.bind(this);
        shimmer.startShimmer();
        configListResults(getIntent());
        configAdapter();
        configRecyclerView();
        configActionBar();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Detiene efecto Shimmer para liberar recursos
        shimmer.stopShimmer();
    }

    //Cargar Intents y Productos
    private void configListResults(Intent intent) {
        query = intent.getStringExtra(Utilities.INTENT_QUERY_ID);
        Log.wtf("Query",query);
        SearchProductsTask productsTask = new SearchProductsTask();
        productsTask.execute(query);

    }

    //configuracion del appBar y activando opcion regresar
    private void configActionBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    //configuracion del adaptador para el reciclerView
    private void configAdapter() {
        adapter = new ProductAdapter(new ArrayList<>(), this);
    }

    //se realiza el seteo del adaptador al reciclerView
    //y se especifica que tipo de reciclerView sera
    //en este caso Linear de un solo item por fila
    private void configRecyclerView() {
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(adapter);
    }

    //se implementan los metodos de la interfaz creada que se comunica con el Adapter
    //para tener control del click de cada item desde el activity
    @Override
    public void onItemClick(ProductML productML, View imgPhoto, View tvName) {
        Intent intent = new Intent(ListProductsActivity.this, DetalleActivity.class);
        Gson gson = new Gson();
        String objectJsonTransform = gson.toJson(productML);
        //Se transforma el Objeto tipo ProductML en un JSON
        //para ser pasado por el el Intent como un String
        intent.putExtra(ProductML.ID, objectJsonTransform);
        Pair<View, String> imgPair = Pair.create(imgPhoto, imgPhoto.getTransitionName());
        Pair<View, String> namePair = Pair.create(tvName, tvName.getTransitionName());

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,
                imgPair, namePair);
        startActivity(intent, options.toBundle());
    }

    //se anulan el metodo, añadiendo nuestros requerimientos
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //Tarea que se ejecutara en otro hilo, encargada de consultar los productos
    //se maneja como una clase interna para tener acceso a la variable global del activity shimmer
    @SuppressLint("StaticFieldLeak")
    private class SearchProductsTask extends AsyncTask<String, Void, ArrayList<ProductML>> {

        //metodo que se ejecutara luego del doInBackground
        //sera el encargado de controlar el error cuando exista alguna excepcion y el resultado sea null
        protected void onPostExecute(ArrayList<ProductML> result) {
            super.onPostExecute(result);
            if (result == null) {
                Toast toast = Toast.makeText(ListProductsActivity.this,"Error de Cuminación",Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL,0,150);
                toast.show();
                finish();
            } else if (result.size() < 1) {
                Toast toast = Toast.makeText(ListProductsActivity.this,"Sin Resultados de Búsqueda",Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL,0,150);
                toast.show();
                finish();
            } else {
                adapter.setList(result);
            }
            shimmer.setVisibility(View.GONE);
            shimmer.stopShimmer();
            //se setea la lista al adaptador del reciclerView
        }

        //metodo que realizara la llamada del metodo estatico
        //el cual retornara la lista de los productos
        //se setea null en caso de una excepcion para manejos en el metodo anulado onPostExecute
        @SuppressLint("WrongThread")
        @Override
        protected ArrayList<ProductML>  doInBackground(String... strings) {
            ArrayList<ProductML> listProducts;
            try {
                listProducts = ApiUtils.getProductsApi(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
                listProducts = null;
            }
            return listProducts;
        }

    }
}