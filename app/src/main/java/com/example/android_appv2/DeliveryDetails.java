package com.example.android_appv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DeliveryDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_details);
    }

    public void orderConfirmation(View view) {
        Toast.makeText(this, "Order has been placed.", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(DeliveryDetails.this, ProductMainActivity.class));
        finish();
    }
}