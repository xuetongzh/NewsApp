package com.google.news.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.news.R;
import com.google.news.bean.NewsBean;

import java.util.List;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.ViewHolder> {
    //Dataset
    private final List<NewsBean> newsBeans;
    //Context
    private final Context context;

    //Constructor
    public VerticalAdapter(Context context, List<NewsBean> newsBeans) {
        this.context = context;
        this.newsBeans = newsBeans;
    }

    //The layout can be obtained by using LayoutInflater, the itemView is the obtained layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View itemView = LayoutInflater.from(context).inflate(R.layout.news_list, null);
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical, parent, false);
        //Set the parent layout for the view
        return new ViewHolder(itemView);
    }

    //Bind data to each sub-item holder
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsBean newsBean = newsBeans.get(position);
        holder.imageView.setImageResource(newsBean.getImageId());
        holder.newsVTitle.setText(newsBean.getNewsTitle());
        holder.newsVContent.setText(newsBean.getNewsContent());

    }

    //Get dataset size
    @Override
    public int getItemCount() {
        return newsBeans.size();
    }

    //Get individual controls
    class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView newsVTitle, newsVContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.newsVImage);
            newsVTitle = (TextView) itemView.findViewById(R.id.newsVTitle);
            newsVContent = (TextView) itemView.findViewById(R.id.newsVContent);

            itemView.setOnClickListener(view -> {
                if (onItemClickListener != null) {
                    onItemClickListener.OnItemClick(view, newsBeans.get(getLayoutPosition()));
                }
            });
        }
    }

    /**
     * Set the interface for the item's listening event
     */
    public interface OnItemClickListener {
        /**
         * The implementation method for clicking each item in the interface. Parameters are self-defined.
         *
         * @param view     The view of the clicked item
         * @param newsBean The data of the clicked item
         */
        public void OnItemClick(View view, NewsBean newsBean);
    }

    //It requires external access, so a set method needs to be set up for easy calling.
    private VerticalAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(VerticalAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
