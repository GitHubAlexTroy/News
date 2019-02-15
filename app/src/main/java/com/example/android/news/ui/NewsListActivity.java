package com.example.android.news.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.news.R;
import com.example.android.news.api.App;
import com.example.android.news.api.NewsApi;
import com.example.android.news.model.Example;
import com.example.android.news.model.News;
import com.example.android.news.ui.adapter.NewsAdapter;
import com.example.android.news.ui.adapter.NewsItemDecoration;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

import static com.example.android.news.api.App.KEY;

public class NewsListActivity extends AppCompatActivity {

    @Inject
    Retrofit retrofit;

    public static final String TRAVEL = "travel";

    private RecyclerView recyclerView;
    private NewsAdapter adapter;
    private List<News> news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_list);

        init();
        getData();
    }

    private void init() {
        recyclerView = findViewById(R.id.recycler_view);
        news = new ArrayList<>();
        adapter = new NewsAdapter(this, news);
        screenConfiguration();

        recyclerView.addItemDecoration(new NewsItemDecoration(getResources().getDimensionPixelOffset(R.dimen.spacing_micro)));
        recyclerView.setAdapter(adapter);

        App.getAppComponent().inject(this);
    }

    private void screenConfiguration() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        }
    }

    private void getData() {
        retrofit.create(NewsApi.class).getNews(TRAVEL, KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Example>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Example example) {
                        adapter.setData(example.getNews());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
