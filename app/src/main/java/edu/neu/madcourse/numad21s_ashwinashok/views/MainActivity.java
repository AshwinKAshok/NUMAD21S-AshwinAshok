package edu.neu.madcourse.numad21s_ashwinashok.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import edu.neu.madcourse.numad21s_ashwinashok.R;
import edu.neu.madcourse.numad21s_ashwinashok.models.Page;
import edu.neu.madcourse.numad21s_ashwinashok.views.ClickyClickActivity;

public class MainActivity extends AppCompatActivity {

    private Button about_me_button;
    private Button clicky_click_button;
    private Button links_button;
    private Button location_button;
    private TextView main_activity_text;
    private int curr_page_num;
    private ArrayList<Page> page_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize activity components
        about_me_button = findViewById(R.id.about_me_button);
        clicky_click_button = findViewById(R.id.clicky_click_button);
        links_button = findViewById(R.id.links_button);
        location_button = findViewById(R.id.location_button);
        main_activity_text = findViewById(R.id.main_activity_text);

        // Initialize the page list;
        page_list = new ArrayList<>();

        // Initialize two pages: 1. Home and 2.About me page
        // 1. Create home page
        Page page = new Page(0, "Hello world!", "About me");
        page_list.add(page);

        // 2. Create about me page;
        page = new Page(1, "Name: Ashwin Ashok \nEmail id:ashok.as@northeastern.edu", "Back to home");
        page_list.add(page);

        curr_page_num = 0;

        about_me_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(curr_page_num == 0)
                    load_page(1);
                else
                    load_page(0);
            }
        });

        clicky_click_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ClickyClickActivity.class);
                startActivity(intent);
            }
        });

        links_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityLinkCollector.class);
                startActivity(intent);
            }
        });

        location_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LocationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void load_page(int page_num) {
        Page page = page_list.get(page_num);

        curr_page_num = page.getPage_num();
        main_activity_text.setText(page.getPage_text());
        about_me_button.setText(page.getButton_text());
    }
}