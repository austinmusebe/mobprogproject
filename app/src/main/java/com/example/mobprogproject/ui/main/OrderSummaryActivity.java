package com.example.mobprogproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class OrderSummaryActivity extends AppCompatActivity {
    TextView summaryTextView;
    Button btnConfirmPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        summaryTextView = findViewById(R.id.summaryTextView);
        btnConfirmPayment = findViewById(R.id.btnConfirmPayment);

        // Retrieve order data from intent
        List<CartItem> orderItems = (List<CartItem>) getIntent().getSerializableExtra("orderItems");
        double totalPrice = getIntent().getDoubleExtra("totalPrice", 0.0);
        String shippingLocation = getIntent().getStringExtra("shippingLocation");

        if (orderItems != null && !orderItems.isEmpty()) {
            StringBuilder summary = new StringBuilder("Order Summary:\n");
            for (CartItem item : orderItems) {
                summary.append(item.getName())
                        .append(" - Quantity: ").append(item.getQuantity())
                        .append(" - Price: $").append(item.getPrice())
                        .append("\n");
            }
            summary.append("\nTotal Price: $").append(totalPrice);
            summary.append("\nShipping Location: ").append(shippingLocation);
            summaryTextView.setText(summary.toString());
        } else {
            Toast.makeText(this, "No items in order.", Toast.LENGTH_SHORT).show();
            finish(); // Exit if no items are present
        }

        btnConfirmPayment.setOnClickListener(view -> {
            Intent i = new Intent(OrderSummaryActivity.this, CheckoutActivity.class);
            startActivity(i);
            finish();
        });
    }
}
