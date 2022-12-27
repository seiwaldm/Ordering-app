package de.androidnewcomer.order_app;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductCheckout extends AppCompatActivity {
    ImageView img;
    TextView name,price,qty, qtyValue, zuZahlen;
    ImageButton addQty, minusQty;
    int q;
    int p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_checkout);
        img = findViewById(R.id.image_product_design_p);
        name = findViewById(R.id.product_name_p);
        price = findViewById(R.id.product_price_p);
        qty = findViewById(R.id.product_qty_p);
        qtyValue = findViewById(R.id.qty_value);
        addQty = findViewById(R.id.add_qty);
        minusQty = findViewById(R.id.qty_minus);
        zuZahlen = findViewById(R.id.ZuZahlen);

        String n = getIntent().getStringExtra("PName").toString();
        p = getIntent().getIntExtra("PPrice",0);
        q = getIntent().getIntExtra("PQty",0);

        name.setText(n);
        price.setText("Preis."+p);
        qty.setText("Anzahl:"+q);
        zuZahlen.setText("Zu Zahlen "+p);
        img.setImageResource(getIntent().getIntExtra("PImage", R.drawable.leberkaese));

        addQty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int qValue = Integer.parseInt(qtyValue.getText().toString());
                ++qValue;
                qtyValue.setText(Integer.toString(qValue));
                int tot = p * qValue;
                zuZahlen.setText("Zu Zahlen "+tot);
            }
        });

        minusQty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int qValue = Integer.parseInt(qtyValue.getText().toString());
                --qValue;
                if(qValue>0)
                    qtyValue.setText(Integer.toString(qValue));
                int tot = p * qValue;
                zuZahlen.setText("Zu Zahlen "+tot);
            }
        });

    }



}