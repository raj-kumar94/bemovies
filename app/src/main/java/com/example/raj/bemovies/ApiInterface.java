package com.example.raj.bemovies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by raj on 06-Aug-17.
 */
public interface ApiInterface {

    @GET("movie/now_playing?api_key=75561f78de9a2c87a09f2747d88f92c6&page=1")
    Call<NowPlayingMovies> getNowPlayingMovies();

    @GET("movie/{id}?api_key=75561f78de9a2c87a09f2747d88f92c6")
    Call<MovDetail> getMovieDetails(@Path("id") int id);

    @GET("movie/{movie_id}/videos?api_key=75561f78de9a2c87a09f2747d88f92c6")
    Call<MovieVideos> getVideo(@Path("movie_id") int movieId);

}
