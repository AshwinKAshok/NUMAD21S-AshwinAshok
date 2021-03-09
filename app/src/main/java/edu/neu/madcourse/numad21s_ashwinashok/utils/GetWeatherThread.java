package edu.neu.madcourse.numad21s_ashwinashok.utils;

import android.os.Looper;

import edu.neu.madcourse.numad21s_ashwinashok.handlers.GetWeatherHandler;
import edu.neu.madcourse.numad21s_ashwinashok.handlers.MainThreadHandler;

public class GetWeatherThread extends Thread {
    private MainThreadHandler mainThreadHandler;
    public GetWeatherHandler getWeatherHandler;

    public GetWeatherThread(MainThreadHandler mainThreadHandler) {
        this.mainThreadHandler = mainThreadHandler;
    }

    @Override
    public void run() {
        Looper.prepare();
        getWeatherHandler = new GetWeatherHandler(mainThreadHandler);
        Looper.loop();
    }
}
