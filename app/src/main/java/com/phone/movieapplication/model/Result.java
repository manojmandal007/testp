package com.phone.movieapplication.model;

import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("overview")
    private String mOverview;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("release_date")
    private String mReleaseDate;

    @SerializedName("popularity")
    private float mPopularity;

    @SerializedName("vote_average")
    private float mVotAverage;

    @SerializedName("backdrop_path")
    private float mImagePath;

    public String getoverview() {
        return mOverview;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public float getPopularity() {
        return mPopularity;
    }

    public float getVoteAverage() {
        return mVotAverage;
    }

    public String getImagePath() {
        return "https://image.tmdb.org/t/p/w500"+ mImagePath;
    }
}
