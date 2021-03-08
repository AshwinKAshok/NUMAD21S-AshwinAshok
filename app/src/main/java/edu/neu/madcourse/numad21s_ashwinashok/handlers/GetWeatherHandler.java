package edu.neu.madcourse.numad21s_ashwinashok.handlers;

import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

public class GetWeatherHandler extends Handler {

    @Override
    public void handleMessage(@NonNull Message msg) {
        GetWeatherData(msg.obj.toString());
    }

    private void GetWeatherData(String location) {

    }
}
