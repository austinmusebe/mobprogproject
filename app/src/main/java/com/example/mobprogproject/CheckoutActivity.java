package com.example.mobprogproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobprogproject.CartItem;
import com.example.mobprogproject.R;

import java.util.List;

public class CheckoutActivity extends AppCompatActivity {
    TextView orderSummaryTextView;
    Button btnConfirmPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        orderSummaryTextView = findViewById(R.id.orderSummaryTextView);
        btnConfirmPayment = findViewById(R.id.btnConfirmPayment);

        // Get the order items from the intent
        List<CartItem> orderItems = (List<CartItem>) getIntent().getSerializableExtra("orderItems");
        if (orderItems != null && !orderItems.isEmpty()) {
            StringBuilder orderSummary = new StringBuilder("Order Summary:\n");
            for (CartItem item : orderItems) {
                orderSummary.append(item.getName()).append(" - Quantity: ")
                        .append(item.getQuantity()).append(" - Price: $").append(item.getPrice()).append("\n");
            }
            orderSummaryTextView.setText(orderSummary.toString());
        } else {
            Toast.makeText(this, "No items in cart.", Toast.LENGTH_SHORT).show();
        }

        btnConfirmPayment.setOnClickListener(view -> {
            // Implement payment processing here (this is just a placeholder)
            Toast.makeText(this, "Payment processed successfully!", Toast.LENGTH_SHORT).show();
            finish(); // Finish this activity and return to the main activity
        });
    }
}
