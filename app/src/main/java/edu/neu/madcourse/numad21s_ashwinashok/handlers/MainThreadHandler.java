package edu.neu.madcourse.numad21s_ashwinashok.handlers;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;

import androidx.annotation.NonNull;

import edu.neu.madcourse.numad21s_ashwinashok.models.WeatherResponseMessage;

public class MainThreadHandler extends Handler {
    private TextView weather_text_view;

    public MainThreadHandler(@NonNull Looper looper, TextView weather_text_view) {
        super(looper);
        this.weather_text_view = weather_text_view;
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        WeatherResponseMessage weatherResponseMessage = (WeatherResponseMessage) msg.obj;
        updateUI(weatherResponseMessage);
    }

    private void updateUI(WeatherResponseMessage weatherResponseMessage) {
        weather_text_view.setText(weatherResponseMessage.getTemp()
                + weatherResponseMessage.getFeels_like()
                + weatherResponseMessage.getDescription()
        );
    }
}
