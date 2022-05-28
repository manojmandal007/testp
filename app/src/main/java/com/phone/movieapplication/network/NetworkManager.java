package com.phone.movieapplication.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {

    private static final String BASE_URL = "https://api.themoviedb.org/3";
    private static Retrofit sRetrofit = null;

    public static RetrofitService getApiService() {
        if (sRetrofit == null) {
            sRetrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit.create(RetrofitService.class);
    }
}
