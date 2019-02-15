package com.example.android.news.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.android.news.R;
import com.example.android.news.ui.NewsDetailsActivity;
import com.example.android.news.model.News;

import java.util.List;

import static com.example.android.news.utils.Utils.formatDateTime;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private Context context;
    private List<News> listItem;

    public NewsAdapter(Context context, List<News> list) {
        this.context = context;
        this.listItem = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {
        final News item = listItem.get(position);

        viewHolder.newsTitle.setText(item.getTitle());
        viewHolder.newsPublishedDate.setText(formatDateTime(context, item.getPublishDate()));
        viewHolder.newsCategory.setText(item.getSection());
        viewHolder.newsPreviewText.setText(item.getAbstractDescription());

        Glide.with(context).load(item.getMultimedia().get(1).getUrl()).into(viewHolder.newsImage);

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsDetailsActivity.newIntent(context, item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private ImageView newsImage;
        private TextView newsCategory;
        private TextView newsTitle;
        private TextView newsPreviewText;
        private TextView newsPublishedDate;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.card_view);
            newsCategory = itemView.findViewById(R.id.news_category);
            newsTitle = itemView.findViewById(R.id.news_item_title);
            newsPreviewText = itemView.findViewById(R.id.news_item_preview_text);
            newsPublishedDate = itemView.findViewById(R.id.news_item_published_date);
            newsImage = itemView.findViewById(R.id.news_item_image);
        }
    }

    public void setData(List<News> list) {
        listItem.clear();
        listItem.addAll(list);
        if (listItem.isEmpty()) {
            Toast.makeText(context, "No news", Toast.LENGTH_SHORT).show();
        }
        notifyDataSetChanged();
    }
}
