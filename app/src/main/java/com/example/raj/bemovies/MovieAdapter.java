package com.example.raj.bemovies;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by raj on 06-Aug-17.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    Context mContext;
    ArrayList<MovieObject> movieObjects;

    public MovieAdapter(Context context, ArrayList<MovieObject> moviesObject){
        mContext=context;
        this.movieObjects = moviesObject;

    }
    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.movie_items,parent,false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, final int position) {
        holder.movieName.setText(movieObjects.get(position).getMovieName());
        Log.i("pics", "onBindViewHolder: ");
        String baseUrl = "http://image.tmdb.org/t/p/w185";
        Picasso.with(mContext).load(baseUrl+movieObjects.get(position).getMovieImageLink()).into(holder.movieImage);
        holder.rating.setText(movieObjects.get(position).getVote_average());

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent movieDetailsIntent=new Intent(mContext,MovieDeailsActivity.class);
                Log.i("plkj", "onClick: "+movieObjects.get(position).getMovieId());
                movieDetailsIntent.putExtra("id",movieObjects.get(position).getMovieId());
                mContext.startActivity(movieDetailsIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieObjects.size();

    }

    class MovieHolder extends RecyclerView.ViewHolder{

        View v;
        ImageView movieImage;
        TextView movieName;
        TextView rating;
        public MovieHolder(View itemView) {
            super(itemView);
            v=itemView;
            movieImage = (ImageView)itemView.findViewById(R.id.movie_image);
            movieName = (TextView) itemView.findViewById(R.id.movie_name);
            rating = (TextView) itemView.findViewById(R.id.rating);
        }
    }
}
