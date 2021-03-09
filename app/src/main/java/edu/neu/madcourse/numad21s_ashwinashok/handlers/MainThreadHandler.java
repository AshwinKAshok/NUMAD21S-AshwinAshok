package edu.neu.madcourse.numad21s_ashwinashok.handlers;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import edu.neu.madcourse.numad21s_ashwinashok.R;
import edu.neu.madcourse.numad21s_ashwinashok.models.WeatherResponseMessage;

public class MainThreadHandler extends Handler {
    private TextView location_text_view;
    private TextView weather_details_text_view;
    private ProgressBar progressBar;

    public MainThreadHandler(@NonNull Looper looper, TextView location_text_view, ProgressBar progressBar, TextView weather_details_text_view) {
        super(looper);
        this.location_text_view = location_text_view;
        this.weather_details_text_view = weather_details_text_view;
        this.progressBar = progressBar;
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        WeatherResponseMessage weatherResponseMessage = (WeatherResponseMessage) msg.obj;
        updateUI(weatherResponseMessage);
    }

    private void updateUI(WeatherResponseMessage weatherResponseMessage) {
        progressBar.setVisibility(View.GONE);

        location_text_view.setText(R.string.location_name_textview);

        weather_details_text_view.setText("Current temp: " + weatherResponseMessage.getTemp()
                + "\nFeels like: " + weatherResponseMessage.getFeels_like()
                + "\nWeather: " + weatherResponseMessage.getDescription()
        );

    }
}
