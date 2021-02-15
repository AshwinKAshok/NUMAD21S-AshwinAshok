package edu.neu.madcourse.numad21s_ashwinashok.adapters;

public interface ItemClickListener {
    void onUpdateClick(int position, String updatedURL);

    void onWebSurfClick(int position);

    String getUrlAtIndex(int position);
}
