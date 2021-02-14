package edu.neu.madcourse.numad21s_ashwinashok.models;

import edu.neu.madcourse.numad21s_ashwinashok.adapters.ItemClickListener;

public class ItemCard {
    private String url;

    public ItemCard(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
