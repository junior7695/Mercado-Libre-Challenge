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

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jaime.ml.challenge.models.ProductML;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ApiUtils {
    public static final String URL = "https://api.mercadolibre.com";
    public static final String endPointProducts = "/sites/MCO/search?q=";

    //Metodos de consulta al API ML

    //Metodo que consulta sugerencias en el API
    public static ArrayList<String> getSuggestionsApi(String query) throws IOException {
        ArrayList<String> listNames = new ArrayList<>();
        java.net.URL url = null;
        HttpURLConnection urlConnection = null;
        query = query.replaceAll(" ","%20");
        url = new URL(ApiUtils.URL+ ApiUtils.endPointProducts+query);
        urlConnection = (HttpURLConnection) url.openConnection();
        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject)jsonParser.parse(
                new InputStreamReader(in, "UTF-8"));
        JsonArray jsonArray = jsonObject.getAsJsonArray("results");
        for (JsonElement iter : jsonArray) {
            JsonObject jsonObjectIter = iter.getAsJsonObject();
            listNames.add(jsonObjectIter.get("title").getAsString());
        }

        if (urlConnection != null) {
            urlConnection.disconnect();
        }
        return listNames;
    }

    public static ArrayList<ProductML> getProductsApi(String query) throws IOException {
        ArrayList<ProductML> listProducts = new ArrayList<>();
        java.net.URL url = null;
        HttpURLConnection urlConnection = null;
        query = query.replaceAll(" ","%20");
        url = new URL(ApiUtils.URL+ ApiUtils.endPointProducts+query);
        urlConnection = (HttpURLConnection) url.openConnection();
        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject)jsonParser.parse(
                new InputStreamReader(in, "UTF-8"));
        JsonArray jsonArray = jsonObject.getAsJsonArray("results");
        Gson gson = new Gson();
        for (JsonElement iter : jsonArray) {
            listProducts.add(gson.fromJson(iter.getAsJsonObject(),ProductML.class));
        }

        if (urlConnection != null) {
            urlConnection.disconnect();
        }
        return listProducts;
    }
}
