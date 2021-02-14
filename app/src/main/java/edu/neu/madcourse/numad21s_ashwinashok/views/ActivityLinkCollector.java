package edu.neu.madcourse.numad21s_ashwinashok.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import edu.neu.madcourse.numad21s_ashwinashok.R;
import edu.neu.madcourse.numad21s_ashwinashok.adapters.RecyclerViewAdapter;
import edu.neu.madcourse.numad21s_ashwinashok.adapters.RecyclerViewHolder;
import edu.neu.madcourse.numad21s_ashwinashok.models.ItemCard;

public class ActivityLinkCollector extends AppCompatActivity implements RecyclerView.OnI{

    private ArrayList<ItemCard> itemList = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerViewHolder recyclerViewHolder;
    private RecyclerView.LayoutManager recyclerViewLayoutManager;
    private FloatingActionButton addButton;

    private static final String KEY_OF_INSTANCE = "KEY_OF_INSTANCE";
    private static final String NUMBER_OF_ITEMS = "NUMBER_OF_ITEMS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_collector);

        init(savedInstanceState);

        addButton = findViewById(R.id.addUrlItem);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void init(Bundle savedInstanceState) {

        initialItemData(savedInstanceState);
        createRecyclerView();
    }

    private void createRecyclerView() {
        recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerViewAdapter = new RecyclerViewAdapter(itemList);

         itemClickListener =
    }


}