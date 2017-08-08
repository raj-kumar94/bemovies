package com.example.raj.bemovies;

import com.google.gson.annotations.SerializedName;

/**
 * Created by raj on 06-Aug-17.
 */
public class MovieObject {
    @SerializedName("title")
    String movieName;
    @SerializedName("id")
    int movieId;
    @SerializedName("backdrop_path")
    String movieImageLink;

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    String vote_average;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieImageLink() {
        return movieImageLink;
    }

    public void setMovieImageLink(String movieImageLink) {
        this.movieImageLink = movieImageLink;
    }

    public MovieObject(String movieName, int movieId, String movieImageLink, String vote_average) {
        this.movieName = movieName;
        this.movieId = movieId;
        this.movieImageLink = movieImageLink;
        this.vote_average = vote_average;
    }
}
