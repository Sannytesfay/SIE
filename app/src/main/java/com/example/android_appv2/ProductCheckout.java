package com.example.android_appv2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductCheckout extends AppCompatActivity {
    ImageView img;
    TextView name, price, qty, qtyValue, totalTxt;
    ImageButton addQty, minusQty;
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
        totalTxt = findViewById(R.id.total);

        String n = getIntent().getStringExtra("PName").toString();
        int p = getIntent().getIntExtra("PPrice", 0);
        int q = getIntent().getIntExtra("PQty", 0);

        name.setText(n);
        price.setText("$" +p);
        qty.setText("Available QTY: "+q);
        totalTxt.setText("Total: $ "+p);
        img.setImageResource(getIntent().getIntExtra("PImage", R.drawable.brown_leather_couch));

        addQty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int qValue = Integer.parseInt(qtyValue.getText().toString());
                ++qValue;
                if(qValue <= q){
                    qtyValue.setText(Integer.toString(qValue));
                    int tot = p * qValue;
                    totalTxt.setText("Total: $ "+tot);
                }
            }
        });

        minusQty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int qValue = Integer.parseInt(qtyValue.getText().toString());
                --qValue;
                if(qValue > 0){
                    qtyValue.setText(Integer.toString(qValue));
                    int tot = p * qValue;
                    totalTxt.setText("Total: $ "+tot);
                }
            }
        });
    }

    public void openDeliveryDetails(View view) {
        startActivity(new Intent(ProductCheckout.this, DeliveryDetails.class));
    }
}