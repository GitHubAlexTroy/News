package com.example.android.news.di.components;

import com.example.android.news.ui.NewsListActivity;
import com.example.android.news.di.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class})
public interface NetComponent {
    void inject(NewsListActivity activity);
}
