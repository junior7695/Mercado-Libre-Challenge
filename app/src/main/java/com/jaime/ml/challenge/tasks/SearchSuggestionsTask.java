package com.jaime.ml.challenge.tasks;

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

import android.os.AsyncTask;

import androidx.appcompat.widget.SearchView;

import com.jaime.ml.challenge.models.Suggestion;
import com.jaime.ml.challenge.utils.ApiUtils;
import com.jaime.ml.challenge.utils.Utilities;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionsTask extends AsyncTask<String, Void, ArrayList<String>> {

    SearchView searchView;

    public SearchSuggestionsTask(SearchView searchView) {
        this.searchView = searchView;
    }

    protected void onPostExecute(ArrayList<String> result) {
        super.onPostExecute(result);
        if (result.size() > 0) {
            Utilities.loadSuggestions(searchView,result);
        } else {
            List<Suggestion> suggestions = SQLite
                    .select()
                    .from(Suggestion.class)
                    .queryList();
            Utilities.loadSuggestionsSaved(searchView,suggestions);
        }
    }

    @Override
    protected ArrayList<String>  doInBackground(String... strings) {
        ArrayList<String> suggestions = new ArrayList<>();
        try {
            suggestions = ApiUtils.getSuggestionsApi(strings[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return suggestions;
    }

}
