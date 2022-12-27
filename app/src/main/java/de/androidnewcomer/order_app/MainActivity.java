package de.androidnewcomer.order_app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProductAdapter adapter;
    ArrayList<Product> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.main_recycler);
        list = new ArrayList<>();
        list.add(new Product("Leberkas", "1",3,R.drawable.leberkaese, 20));

        adapter = new ProductAdapter(this,list);
        LinearLayoutManager llm = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
    }
}

