package com.example.raj.bemovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDeailsActivity extends AppCompatActivity {

    int id;
    ImageView image;
    TextView title;
    TextView avg_rating;
    TextView overview;
    TextView releaseDate;
    TextView tagline;
    Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_deails);
        image = (ImageView)findViewById(R.id.poster);
        title = (TextView) findViewById(R.id.movie_title);
        avg_rating = (TextView) findViewById(R.id.vote_average);
        overview = (TextView) findViewById(R.id.overview);
        releaseDate = (TextView) findViewById(R.id.release_date);
        tagline = (TextView) findViewById(R.id.tagline);
        playButton = (Button) findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiInterface apiInterface=ApiClient.getApiInterface();
                Call<MovieVideos> call = apiInterface.getVideo(id);
                call.enqueue(new Callback<MovieVideos>() {
                    @Override
                    public void onResponse(Call<MovieVideos> call, Response<MovieVideos> response) {
                        Log.i("hello", "onResponse: "+response.toString());
                        if(response.isSuccessful()){
                            String key = response.body().getResults().get(0).getKey();
                            startActivity(new Intent(MovieDeailsActivity.this,YoutubeActivity.class).putExtra("videoKey",key));
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieVideos> call, Throwable t) {
                        Log.i("hello", "onResponse: "+t.getMessage());

                    }
                });
            }
        });
        id=getIntent().getIntExtra("id",-1);
        fetchData();
    }
    private void fetchData(){
        ApiInterface apiInterface=ApiClient.getApiInterface();
        Call<MovDetail> call = apiInterface.getMovieDetails(id);
        call.enqueue(new Callback<MovDetail>() {
            @Override
            public void onResponse(Call<MovDetail> call, Response<MovDetail> response) {
                Log.i("plkjio", "onResponse: "+response.toString());

                if(response.isSuccessful()){
                    Log.i("plkjio", "onResponse: "+response.message());
                    String baseUrl = "http://image.tmdb.org/t/p/w185";
                    Picasso.with(MovieDeailsActivity.this).load(baseUrl+response.body().getBackdrop_path()).into(image);
                    title.setText(response.body().getOriginal_title());
                    avg_rating.setText(response.body().getVote_average());
                    overview.setText(response.body().getOverview());
                    releaseDate.setText(response.body().getRelease_date());
                    tagline.setText(response.body().getTagline());
                }
            }

            @Override
            public void onFailure(Call<MovDetail> call, Throwable t) {
                Log.i("plkjio", "onResse:"+t.getMessage());
            }
        });
    }
}
