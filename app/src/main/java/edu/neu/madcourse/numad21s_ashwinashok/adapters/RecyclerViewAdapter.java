package edu.neu.madcourse.numad21s_ashwinashok.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.neu.madcourse.numad21s_ashwinashok.R;
import edu.neu.madcourse.numad21s_ashwinashok.models.ItemCard;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private final ArrayList<ItemCard> itemList;

    public RecyclerViewAdapter(ArrayList<ItemCard> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_card, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        ItemCard currentItem = itemList.get(position);

        holder.urlTextView.setText(currentItem.getUrl());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
