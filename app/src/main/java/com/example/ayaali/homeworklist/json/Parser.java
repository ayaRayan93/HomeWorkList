package com.example.ayaali.homeworklist.json;

import com.example.ayaali.homeworklist.models.HomeWork;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AyaAli on 28/12/2017.
 */

public class Parser {

    public static List<HomeWork> parseStringToJson(String data) {
        List<HomeWork> modelMovies;

        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.optJSONArray("results");
            modelMovies = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject movieJsonObject = jsonArray.getJSONObject(i);

                String date = movieJsonObject.optString("release_date");
                String title = movieJsonObject.optString("original_title");



                HomeWork movie = new HomeWork();
                movie.setTitel(title);
                movie.setDate(date);

                modelMovies.add(movie);


            }

            return modelMovies;

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }
}
