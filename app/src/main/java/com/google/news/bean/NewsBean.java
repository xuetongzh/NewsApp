package com.google.news.bean;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class NewsBean implements Serializable {
    private int imageId;
    private String newsTitle;
    private String newsContent;

    public NewsBean(int imageId, String newsTitle, String newsContent) {
        this.imageId = imageId;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
    }

    @NonNull
    @Override
    public String toString() {
        return "NewsBean{" +
                "imageId=" + imageId +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsContent='" + newsContent + '\'' +
                '}';
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }
}
