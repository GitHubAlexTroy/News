package com.example.android.news.api;

import android.app.Application;

import com.example.android.news.di.components.DaggerNetComponent;
import com.example.android.news.di.components.NetComponent;
import com.example.android.news.di.modules.NetworkModule;

public class App extends Application {

    public static final String KEY = "imKZBxiLhWnexNpvLenTZDJdBunudh6s";
    private static final String BASE_URL = "https://api.nytimes.com/svc/";
    private static NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        netComponent = DaggerNetComponent.builder()
                .networkModule(new NetworkModule(BASE_URL))
                .build();
    }

    public static NetComponent getAppComponent() {
        return netComponent;
    }
}
