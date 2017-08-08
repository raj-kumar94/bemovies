package com.example.raj.bemovies;

import android.widget.Button;

import java.sql.Struct;

/**
 * Created by raj on 06-Aug-17.
 */
public class MovDetail {
    //@SerializedName("genre")
    //String genre;
    String original_title;
    String overview;
    String release_date;
    String tagline;
    String vote_average;
    String backdrop_path;

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public MovDetail(String original_title, String overview, String release_date, String tagline, String vote_average, String backdrop_path) {

        this.original_title = original_title;
        this.overview = overview;
        this.release_date = release_date;
        this.tagline = tagline;
        this.vote_average = vote_average;
        this.backdrop_path = backdrop_path;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }
}
