package com.phone.movieapplication.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.phone.movieapplication.R;
import com.phone.movieapplication.adapter.MovieListAdapter;
import com.phone.movieapplication.databinding.FragmentMovieListBinding;
import com.phone.movieapplication.model.MovieData;
import com.phone.movieapplication.model.Result;
import com.phone.movieapplication.viewmodel.MovieViewModel;

import java.util.ArrayList;

public class MovieListFragment extends Fragment {

    private FragmentMovieListBinding mMovieListBinding;
    private MovieViewModel mViewModel;
    private ArrayList<Result> mMovieList = new ArrayList<>();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        mMovieListBinding = FragmentMovieListBinding.inflate(inflater, container, false);
        return mMovieListBinding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView(){
        mViewModel =  ViewModelProviders.of(this).get(MovieViewModel.class);
        mViewModel.getMovieList();
        observeData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mMovieListBinding.movieRecyclerView.setLayoutManager(layoutManager);
        setAdapter();
    }

    private void observeData(){
        mViewModel.getMovieList();
        mViewModel.getMutableLiveData().observe(getViewLifecycleOwner(), new Observer<MovieData>() {
            @Override
            public void onChanged(MovieData movieData) {
                // notify
                mMovieList.addAll(movieData.getResults());
                mMovieListBinding.movieRecyclerView.getAdapter().notifyDataSetChanged();
            }
        });
    }

    private void setAdapter(){
        MovieListAdapter adapter = new MovieListAdapter(mMovieList);
        mMovieListBinding.movieRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mMovieListBinding = null;
    }
}