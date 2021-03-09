package edu.neu.madcourse.numad21s_ashwinashok.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import edu.neu.madcourse.numad21s_ashwinashok.R;
import edu.neu.madcourse.numad21s_ashwinashok.handlers.MainThreadHandler;
import edu.neu.madcourse.numad21s_ashwinashok.models.GetWeatherMessage;
import edu.neu.madcourse.numad21s_ashwinashok.utils.GetWeatherThread;

public class WebServiceActivity extends AppCompatActivity {

    private TextView location_name_text_view;
    private TextView weather_details_text_view;
    private ProgressBar progressBar;
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
        progressBar = findViewById(R.id.weather_progress_bar);
        progressBar.setVisibility(View.GONE);

        mainThreadHandler = new MainThreadHandler(Looper.getMainLooper(), location_name_text_view, progressBar, weather_details_text_view);

        GetWeatherThread getWeatherThread = new GetWeatherThread(mainThreadHandler);
        getWeatherThread.setName("Get-Weather-Thread");
        getWeatherThread.start();
        String test = String.valueOf(location_name_text_view.getText());

        if(savedInstanceState != null) {
            weather_details_text_view.setText(savedInstanceState.getString("weather_details"));
            location_name_text_view.setText(savedInstanceState.getString("location_name"));
        }

        get_weather_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isNetworkAvailable()) {
                    if( !String.valueOf(location_name_text_view.getText()).isEmpty()
                        && !String.valueOf(location_name_text_view.getText()).equals(getResources().getString(R.string.location_name_textview))
                        && String.valueOf(location_name_text_view.getText()).matches("[a-zA-Z0-9\\s]*")
                    ) {
                        Message message = Message.obtain();
                        message.obj = new GetWeatherMessage(geocoding_url, geocoding_api_key, location_name_text_view.getText().toString(), weather_url, weather_api_key);
                        getWeatherThread.getWeatherHandler.sendMessage(message);
                        progressBar.setVisibility(View.VISIBLE);
                    } else {
                        // Show snackbar telling user that the name of city is not entered
                        Snackbar mySnackbar = Snackbar.make(location_name_text_view, "Invalid Location!! Please enter a correct city name (No special symbols allowed)", Snackbar.LENGTH_SHORT);
                        mySnackbar.setAction("CLOSE", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                location_name_text_view.setText(R.string.location_name_textview);
                                mySnackbar.dismiss();
                            }
                        });

                        mySnackbar.show();
                    }
                } else {
                    Snackbar mySnackbar = Snackbar.make(location_name_text_view, "Network connectivity not available!! Kindly enable Wifi/Cellular network.", Snackbar.LENGTH_SHORT);
                    mySnackbar.setAction("CLOSE", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            location_name_text_view.setText(R.string.location_name_textview);
                            mySnackbar.dismiss();
                        }
                    });

                    mySnackbar.show();
                }
            }
        });
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("weather_details", weather_details_text_view.getText().toString());
        outState.putString("location_name", location_name_text_view.getText().toString());
    }
}