package com.example.raj.bemovies;

import java.util.ArrayList;

/**
 * Created by raj on 06-Aug-17.
 */
public class NowPlayingMovies {
    ArrayList<MovieObject> results;

    public ArrayList<MovieObject> getResults() {
        return results;
    }

    public void setResults(ArrayList<MovieObject> results) {
        this.results = results;
    }

    public NowPlayingMovies(ArrayList<MovieObject> results) {

        this.results = results;
    }
}
