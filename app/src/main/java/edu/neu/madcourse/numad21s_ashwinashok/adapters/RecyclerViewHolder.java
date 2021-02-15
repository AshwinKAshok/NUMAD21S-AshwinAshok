package edu.neu.madcourse.numad21s_ashwinashok.adapters;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.neu.madcourse.numad21s_ashwinashok.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView urlTextView;
    public Button urlButton;
    public Button updateUrlButton;
    public RecyclerViewHolder(View itemView, ItemClickListener listener) {
        super(itemView);

        urlTextView = itemView.findViewById(R.id.url_text);
        urlButton = itemView.findViewById(R.id.url_button);
        updateUrlButton = itemView.findViewById(R.id.update_url_button);

        urlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        updateUrlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(listener != null) {
                    int position = getLayoutPosition();
                    if(position != RecyclerView.NO_POSITION) {
                        String updatedURL = urlTextView.getText().toString();

                        listener.onUpdateClick(position, updatedURL);
                    }
                }
            }
        });
    }

    public static boolean isValidURL(String url) {
        // Regex to check valid URL
        String regex = "((http|https)://)"
                + "[a-zA-Z0-9@:%._\\+~#?&//=]"
                + "{2,256}\\.[a-z]"
                + "{2,6}\\b([-a-zA-Z0-9@:%"
                + "._\\+~#?&//=]*)";

        Pattern p = Pattern.compile(regex);

        if (url == null) {
            return false;
        }
        Matcher m = p.matcher(url);
        return m.matches();
    }
}
