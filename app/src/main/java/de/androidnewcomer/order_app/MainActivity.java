package de.androidnewcomer.order_app;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

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
        Log.d("MainActivity", "Hello LOG!");
        
        new LoadProductsTask().execute();
        // loadProducts();

        adapter = new ProductAdapter(this,list);
        LinearLayoutManager llm = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
    }

    private void loadProducts(){
        Log.d("function call", this.list.toString());

        RequestQueue volleyQueue = Volley.newRequestQueue(this);
        String url = "https://rk.seiwald.club/api/collections/products/records";
        // String url = "https://google.com";
        //make an http GET-Request to url:
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                response -> {
                    Log.d("response", ":)");
                    list.add(new Product("Schnitzerl", "2",9,R.drawable.leberkaese, 20));
                },
                error -> {
                    Log.e("error", error.toString());
                }
        );
        volleyQueue.addRequestEventListener((type, request1) -> {
            Log.d("request", type.toString() + " " + request1 + "!!!!");
        });
        volleyQueue.add(request);
        Log.d("function end", ":(");
    }


    private class LoadProductsTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            loadProducts();
            return null;
        }

    }
}

