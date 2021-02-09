package edu.neu.madcourse.numad21s_ashwinashok;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClickyClick extends AppCompatActivity {

    private Button button_a;
    private Button button_b;
    private Button button_c;
    private Button button_d;
    private Button button_e;
    private Button button_f;
    private Button clicky_click_back_button;

    private String last_button_pressed;

    private TextView button_pressed_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicky_click);

        button_a = findViewById(R.id.button_a);
        button_b = findViewById(R.id.button_b);
        button_c = findViewById(R.id.button_c);
        button_d = findViewById(R.id.button_d);
        button_e = findViewById(R.id.button_e);
        button_f = findViewById(R.id.button_f);
        clicky_click_back_button = findViewById(R.id.clicky_click_back_button);

        button_pressed_text = findViewById(R.id.button_pressed_text_view);

        last_button_pressed = "No button pressed!!";

        if(savedInstanceState != null) {
            last_button_pressed = savedInstanceState.getString("last_button_pressed");
            button_pressed_text.setText(last_button_pressed);
        }

        button_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                last_button_pressed = "Pressed: A";
                button_pressed_text.setText("Pressed: A");
            }
        });

        button_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                last_button_pressed = "Pressed: B";
                button_pressed_text.setText("Pressed: B");
            }
        });

        button_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                last_button_pressed = "Pressed: C";
                button_pressed_text.setText("Pressed: C");
            }
        });


        button_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                last_button_pressed = "Pressed: D";
                button_pressed_text.setText("Pressed: D");
            }
        });

        button_e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                last_button_pressed = "Pressed: E";
                button_pressed_text.setText("Pressed: E");
            }
        });

        button_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                last_button_pressed = "Pressed: F";
                button_pressed_text.setText("Pressed: F");
            }
        });

        clicky_click_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("last_button_pressed", last_button_pressed);
    }
}