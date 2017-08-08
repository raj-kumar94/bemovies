package com.example.raj.bemovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MovieAdapter adapter;
    ArrayList<MovieObject> movieObjectArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieObjectArrayList=new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.movieList);

        //pass to Adapter where adapter will put the item on the card
        adapter = new MovieAdapter(MainActivity.this, movieObjectArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(adapter);

        fetchData();

    }
    private void fetchData(){
        ApiInterface apiInterface=ApiClient.getApiInterface();

        //1--> getting result of first page
        Call<NowPlayingMovies> call = apiInterface.getNowPlayingMovies();
        call.enqueue(new Callback<NowPlayingMovies>() {
            @Override
            public void onResponse(Call<NowPlayingMovies> call, Response<NowPlayingMovies> response) {
                Log.i("polki", "onResponse: "+response.toString());

                if(response.isSuccessful()){
                    movieObjectArrayList .addAll( response.body().getResults());

                    adapter.notifyDataSetChanged();
                    Log.i("polki", "onResponse: "+response.body().toString());
                    Log.i("polki", "onResponse: "+movieObjectArrayList.size());

                }
            }
            //waits for 5 seconds for the response
            @Override
            public void onFailure(Call<NowPlayingMovies> call, Throwable t) {
                Log.i("polki", "onRespo "+t.getMessage());

            }
        });
    }
}
