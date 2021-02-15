package edu.neu.madcourse.numad21s_ashwinashok.adapters;

import android.content.Intent;

public interface ItemClickListener {
    void onUpdateClick(int position, String updatedURL);

    void onWebSurfClick(int position, String url);

    String getUrlAtIndex(int position);
}
