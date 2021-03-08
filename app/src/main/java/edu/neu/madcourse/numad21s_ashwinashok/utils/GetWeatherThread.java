package edu.neu.madcourse.numad21s_ashwinashok.utils;

import android.os.Looper;

import edu.neu.madcourse.numad21s_ashwinashok.handlers.GetWeatherHandler;

public class GetWeatherThread extends Thread {
    public GetWeatherHandler getWeatherHandler;

    @Override
    public void run() {
        Looper.prepare();
        getWeatherHandler = new GetWeatherHandler();
        Looper.loop();
    }
}
