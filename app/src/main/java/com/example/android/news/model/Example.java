package com.example.android.news.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Example implements Serializable {
    @SerializedName("status")
    private String status;

    @SerializedName("results")
    private List<News> news;

    public String getStatus() {
        return status;
    }

    public List<News> getNews() {
        return news;
    }
}
