package edu.neu.madcourse.numad21s_ashwinashok.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import edu.neu.madcourse.numad21s_ashwinashok.R;

public class WebServiceActivity extends AppCompatActivity {

    private TextView location_name;
    private Button get_weather;
    private String api_key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service);
    }
}