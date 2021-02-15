package edu.neu.madcourse.numad21s_ashwinashok.adapters;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

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
                if(isValidURL(urlTextView.getText().toString())) {
                    int position = getLayoutPosition();

                    if(listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onWebSurfClick(position, urlTextView.getText().toString());
                    } else {
                        Snackbar mySnackbar = Snackbar.make(urlButton, "Oops!! Something went wrong.", Snackbar.LENGTH_SHORT);
                        mySnackbar.setAction("CLOSE", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mySnackbar.dismiss();
                            }
                        });

                        mySnackbar.show();
                    }
                } else {
                    Snackbar mySnackbar = Snackbar.make(updateUrlButton, "Incorrect URL!! Try again.", Snackbar.LENGTH_SHORT);
                    mySnackbar.setAction("CLOSE", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mySnackbar.dismiss();
                        }
                    });

                    mySnackbar.show();
                }
            }
        });

        updateUrlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(listener != null) {
                    int position = getLayoutPosition();
                    if(position != RecyclerView.NO_POSITION) {
                        String updatedURL = urlTextView.getText().toString();
                        if(isValidURL(updatedURL)) {
                            Snackbar mySnackbar = Snackbar.make(updateUrlButton, "URL updated", Snackbar.LENGTH_SHORT);
                            mySnackbar.setAction("CLOSE", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    mySnackbar.dismiss();
                                }
                            });

                            listener.onUpdateClick(position, updatedURL);
                            mySnackbar.show();
                        } else {

                            Snackbar mySnackbar = Snackbar.make(updateUrlButton, "Incorrect URL!! Try again.", Snackbar.LENGTH_SHORT);
                            mySnackbar.setAction("CLOSE", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    mySnackbar.dismiss();
                                }
                            });

                            Log.d("here123:.. invalid url........", listener.getUrlAtIndex(position));
                            urlTextView.setText(listener.getUrlAtIndex(position));
                            mySnackbar.show();
                        }
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
