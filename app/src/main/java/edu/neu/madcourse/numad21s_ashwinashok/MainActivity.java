package edu.neu.madcourse.numad21s_ashwinashok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button about_me_button;
    private TextView main_activity_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        about_me_button = findViewById(R.id.about_me_button);
        main_activity_text = findViewById(R.id.main_activity_text);
    }
}