package com.phone.movieapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieData {

    @SerializedName("page")
    private int mPage;

    @SerializedName("total_pages")
    private int mTotalPages;

    @SerializedName("results")
    private ArrayList<Result> mResults;

    @SerializedName("total_results")
    private int mTotalResults;

    public int getPage ()
    {
        return mPage;
    }

    public int getTotalPages ()
    {
        return mTotalPages;
    }

    public ArrayList<Result> getResults ()
    {
        return mResults;
    }

    public int getTotalResults ()
    {
        return mTotalResults;
    }
}
