package com.phone.movieapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.phone.movieapplication.R;
import com.phone.movieapplication.model.Result;

import java.util.ArrayList;

public class MovieListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final ArrayList<Result> mMovieList;
    public MovieListAdapter(ArrayList<Result> movieList) {
        mMovieList = movieList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.list_movie, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Result data = mMovieList.get(position);
        MovieHolder movieHolder = (MovieHolder) holder;
        movieHolder.mMovieDetail.setText(data.getoverview());
        movieHolder.mMovieTitle.setText(data.getTitle());
        Glide.with(movieHolder.mMovieImage.getContext())
                .load(data.getImagePath())
                .into(movieHolder.mMovieImage);
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        if (mMovieList != null && mMovieList.size() > 0) {
            return mMovieList.size();
        } else {
            return 0;
        }
    }


    static class MovieHolder extends RecyclerView.ViewHolder {
        ImageView mMovieImage;
        TextView mMovieTitle;
        TextView mMovieDetail;

        public MovieHolder(View view) {
            super(view);
            mMovieImage = view.findViewById(R.id.movie_iv);
            mMovieTitle = view.findViewById(R.id.movie_title_tv);
            mMovieDetail = view.findViewById(R.id.movie_detail_tv);
        }
    }
}
