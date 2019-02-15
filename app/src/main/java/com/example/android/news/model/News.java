package com.example.android.news.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class News implements Serializable {
    @SerializedName("subsection")
    private String subsection;

    @SerializedName("section")
    private String section;

    @SerializedName("title")
    private String title;

    @SerializedName("abstract")
    private String abstractDescription;

    @SerializedName("published_date")
    private Date publishDate;

    @SerializedName("multimedia")
    private List<Multimedium> multimedia;

    @SerializedName("url")
    private String url;

    public String getSection() {
        return section;
    }

    public String getSubsection() {
        return subsection;
    }

    public String getTitle() {
        return title;
    }

    public String getAbstractDescription() {
        return abstractDescription;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public List<Multimedium> getMultimedia() {
        return multimedia;
    }

    public String getUrl() {
        return url;
    }
}
