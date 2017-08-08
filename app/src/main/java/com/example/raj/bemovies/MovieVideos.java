package com.example.raj.bemovies;

import java.util.ArrayList;

/**
 * Created by raj on 08-Aug-17.
 */
public class MovieVideos {
    ArrayList<VideoKey> results;

    public ArrayList<VideoKey> getResults() {
        return results;
    }

    public void setResults(ArrayList<VideoKey> results) {
        this.results = results;
    }

    public MovieVideos(ArrayList<VideoKey> results) {

        this.results = results;
    }
}
