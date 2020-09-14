package com.jaime.ml.challenge.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ApiUtils {
    public static final String URL = "https://api.mercadolibre.com";
    public static final String endPointProducts = "/sites/MCO/search?q=";

    //Metodos de consulta al API ML
    public static ArrayList<String> getSuggestionsApi(String query) {
        ArrayList<String> listNames = new ArrayList<>();
        java.net.URL url = null;
        HttpURLConnection urlConnection = null;
        query = query.replaceAll(" ","%20");
        try {
            url = new URL(ApiUtils.URL+ ApiUtils.endPointProducts+query);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = (JsonObject)jsonParser.parse(
                    new InputStreamReader(in, "UTF-8"));
            JsonArray jsonArray = jsonObject.getAsJsonArray("results");
            for (JsonElement iter : jsonArray) {
                JsonObject jsonObject1 = iter.getAsJsonObject();
                listNames.add(jsonObject1.get("title").getAsString());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return listNames;
    }
}
