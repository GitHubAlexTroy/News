package com.example.android.news.api;

import android.support.annotation.NonNull;

import com.example.android.news.model.Example;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("topstories/v2/{section}.json")
    Single<Example> getNews(
            @Path("section") @NonNull String section,
            @Query("api-key") String key);
}
