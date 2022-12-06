package com.example.android_appv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ProductMainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProductAdapter adapter;
    ArrayList<Products> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_activity_main);
        recyclerView = findViewById(R.id.main_recycler);
        list = new ArrayList<>();

        list.add(new Products("Couch", "1", 35, R.drawable.brown_leather_couch, 25));
        list.add(new Products("North Face Jester Backpack", "2", 60, R.drawable.north_face_bag, 150));
        list.add(new Products("Almond MIlk and Cereal", "3", 10, R.drawable.groceries, 25));
        list.add(new Products("Calculus 1 TextBook", "4", 100, R.drawable.cal_text, 25));

        adapter = new ProductAdapter(this, list);
        LinearLayoutManager llm = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
    }
}