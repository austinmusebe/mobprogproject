package com.example.mobprogproject;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class cart extends AppCompatActivity {
    RecyclerView recyclerView;
    CartAdapter cartAdapter;
    List<CartItem> cartItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.recycler_cart);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample Data for the cart items
        cartItems = new ArrayList<>();
        cartItems.add(new CartItem("Item 1", 2, 19.99));
        cartItems.add(new CartItem("Item 2", 1, 9.99));
        cartItems.add(new CartItem("Item 3", 5, 14.99));

        List<CartItem> cartItems = (List<CartItem>) getIntent().getSerializableExtra("cartItems");

        cartAdapter = new CartAdapter(cartItems);
        recyclerView.setAdapter(cartAdapter);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}