package com.phone.movieapplication.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.phone.movieapplication.R;
import com.phone.movieapplication.databinding.FragmentMovieDetailBinding;

public class MovieDetailFragment extends Fragment {

    private FragmentMovieDetailBinding mMovieDetailBinding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        mMovieDetailBinding = FragmentMovieDetailBinding.inflate(inflater, container, false);
        return mMovieDetailBinding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mMovieDetailBinding = null;
    }

}