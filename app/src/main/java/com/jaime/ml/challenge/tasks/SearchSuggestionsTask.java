package com.jaime.ml.challenge.tasks;

import android.app.SearchManager;
import android.database.MatrixCursor;
import android.os.AsyncTask;
import android.provider.BaseColumns;

import androidx.appcompat.widget.SearchView;
import androidx.cursoradapter.widget.CursorAdapter;

import com.jaime.ml.challenge.utils.ApiUtils;

import java.util.ArrayList;

public class SearchSuggestionsTask extends AsyncTask<String, Void, ArrayList<String>> {

    SearchView searchView;

    public SearchSuggestionsTask(SearchView searchView) {
        this.searchView = searchView;
    }

    protected void onPostExecute(ArrayList<String> result) {
        super.onPostExecute(result);
        loadSuggestions(searchView,result);
    }

    @Override
    protected ArrayList<String>  doInBackground(String... strings) {
        return ApiUtils.getSuggestionsApi(strings[0]);
    }

    private void loadSuggestions(SearchView searchView, ArrayList<String> searchResponse) {

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
}
