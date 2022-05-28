package com.phone.movieapplication.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.phone.movieapplication.model.MovieData;
import com.phone.movieapplication.network.NetworkManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel  extends ViewModel {

    private final String API_KEY = "38a73d59546aa378980a88b645f487fc";
    private MutableLiveData<MovieData> mMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<MovieData> getMutableLiveData(){
        return mMutableLiveData;
    }
    public void getMovieList(){
        Call<MovieData> call =  NetworkManager.getApiService().getMovieData(API_KEY);
        call.enqueue(new Callback<MovieData>() {
            @Override
            public void onResponse(Call<MovieData> call, Response<MovieData> response) {
                mMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<MovieData> call, Throwable t) {

            }
        });

    }
}
