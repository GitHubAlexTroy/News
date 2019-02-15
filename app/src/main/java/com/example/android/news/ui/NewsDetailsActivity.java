package com.example.android.news.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.news.R;
import com.example.android.news.model.News;

import static com.example.android.news.utils.Utils.formatDateTime;

public class NewsDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_NEWS_ITEM = "extra_news_item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_details);

        setData();
    }

    private void setData() {
        final News newsItem = (News) getIntent().getSerializableExtra(EXTRA_NEWS_ITEM);

        final ImageView newsImage = findViewById(R.id.news_image_detail);
        final TextView newsTitle = findViewById(R.id.news_title_detail);
        final TextView newsPublishedDate = findViewById(R.id.news_published_date_detail);
        final TextView newsFullText = findViewById(R.id.news_full_text_detail);

        Glide.with(this)
                .load(newsItem.getMultimedia().get(3).getUrl())
                .into(newsImage);

        newsTitle.setText(newsItem.getTitle());
        newsPublishedDate.setText(formatDateTime(getApplicationContext(), newsItem.getPublishDate()));
        newsFullText.setText(newsItem.getAbstractDescription());
    }

    public static void newIntent(Context context, News item) {
        context.startActivity(new Intent(context, NewsDetailsActivity.class).putExtra(EXTRA_NEWS_ITEM, item));
    }

}
