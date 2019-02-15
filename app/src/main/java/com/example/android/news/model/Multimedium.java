package com.example.android.news.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Multimedium implements Serializable {
    @SerializedName("type")
    private String type;

    @SerializedName("url")
    private String url;

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }
}
