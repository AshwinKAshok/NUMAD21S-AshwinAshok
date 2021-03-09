package edu.neu.madcourse.numad21s_ashwinashok.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.neu.madcourse.numad21s_ashwinashok.R;
import edu.neu.madcourse.numad21s_ashwinashok.handlers.MainThreadHandler;
import edu.neu.madcourse.numad21s_ashwinashok.models.GetWeatherMessage;
import edu.neu.madcourse.numad21s_ashwinashok.utils.GetWeatherThread;

public class WebServiceActivity extends AppCompatActivity {

    private TextView location_name_text_view;
    private TextView weather_details_text_view;
    private Button get_weather_button;
    private String geocoding_api_key;
    private String geocoding_url;
    private String weather_api_key;
    private String weather_url;
    private MainThreadHandler mainThreadHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service);

        geocoding_url = "https://api.opencagedata.com";
        geocoding_api_key = "0b6a0914cf224bf2a7fe7d8e39acf00e";
        weather_url = "https://api.openweathermap.org";
        weather_api_key = "bbc33aa848a57dbca2073a2db25ad3a1";

        location_name_text_view = findViewById(R.id.location_name_textview);
        weather_details_text_view = findViewById(R.id.weather_details_text_view);
        weather_details_text_view.setText("Weather details not available!!\nEnter city name and click the button");
        get_weather_button = findViewById(R.id.get_weather_button);

        mainThreadHandler = new MainThreadHandler(Looper.getMainLooper(), location_name_text_view);

        GetWeatherThread getWeatherThread = new GetWeatherThread(mainThreadHandler);
        getWeatherThread.setName("Get-Weather-Thread");
        getWeatherThread.start();

        get_weather_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(location_name_text_view.getText() != "") {
                    Message message = Message.obtain();
                    message.obj = new GetWeatherMessage(geocoding_url, geocoding_api_key, location_name_text_view.getText().toString(), weather_url, weather_api_key);
                    getWeatherThread.getWeatherHandler.sendMessage(message);
                } else {
                    // Show snackbar telling user that the name of city is not entered
                }
            }
        });

    }


}