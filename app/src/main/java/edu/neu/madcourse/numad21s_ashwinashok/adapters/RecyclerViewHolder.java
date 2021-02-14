package edu.neu.madcourse.numad21s_ashwinashok.adapters;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.neu.madcourse.numad21s_ashwinashok.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView urlTextView;
    public Button urlButton;
    public RecyclerViewHolder(View itemView) {
        super(itemView);

        urlTextView = itemView.findViewById(R.id.url_text);
        urlButton = itemView.findViewById(R.id.url_button);

        urlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
