package com.phone.movieapplication.network;

import com.phone.movieapplication.model.MovieData;

import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("/movie/popular")
    Call<MovieData> getMovieData(@Query("api_key") String key);
}
