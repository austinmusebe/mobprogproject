package com.example.mobprogproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class cart extends AppCompatActivity {
    RecyclerView recyclerView;
    CartAdapter cartAdapter;
    List<CartItem> cartItems;
    Button btnCheckout, btnContinueShopping;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.recycler_cart);
        btnCheckout = findViewById(R.id.btnCheckout);
        btnContinueShopping = findViewById(R.id.btnContinueShopping);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample Data for the cart items
        cartItems = new ArrayList<>();
        cartItems.add(new CartItem("Item 1", 2, 19.99));
        cartItems.add(new CartItem("Item 2", 1, 9.99));
        cartItems.add(new CartItem("Item 3", 5, 14.99));

        List<CartItem> cartItems = (List<CartItem>) getIntent().getSerializableExtra("cartItems");

        cartAdapter = new CartAdapter(cartItems);
        recyclerView.setAdapter(cartAdapter);

        // Initialize Firebase database reference
        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        // Your existing code
        btnCheckout.setOnClickListener(view -> {
            saveOrderToDatabase();
            saveOrderToDatabase();

            double totalPrice = 0.0;
            for (CartItem item : cartItems) {
                totalPrice += item.getPrice() * item.getQuantity();
            }

            // Get the shipping location from Firebase or your local variable
            String shippingLocation = "Your Shipping Location"; // Replace with your actual shipping location logic

            // Get the current date and time
            String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());


            Intent checkoutIntent = new Intent(cart.this, com.example.mobprogproject.OrderSummaryActivity.class);
            checkoutIntent.putExtra("orderItems", (Serializable) cartItems); // Pass the cart items
            checkoutIntent.putExtra("totalPrice", totalPrice); // Pass the total price
            checkoutIntent.putExtra("shippingLocation", shippingLocation); // Pass the shipping location
            checkoutIntent.putExtra("orderDate", currentDateTime); // Pass the current date/time
            startActivity(checkoutIntent);

                }
        );


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnContinueShopping.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(cart.this, categories.class);
                startActivity(i);
                finish();
            }
        });


    }

    private void saveOrderToDatabase() {
        String userId = mAuth.getCurrentUser().getUid();
        DatabaseReference orderRef = databaseReference.child("users").child(userId).child("orderHistory").push(); // Creates a new order entry

        // Get the current date and time
        String currentDateTime = java.text.DateFormat.getDateTimeInstance().format(new java.util.Date());
        String shippingLocation = ""; // Set this from your shipping location logic

        // Prepare a list to store order details
        List<Map<String, Object>> orderDetailsList = new ArrayList<>();

        // Iterate through the cart items and save them in the order history
        for (CartItem item : cartItems) {
            Map<String, Object> orderDetails = new HashMap<>();
            orderDetails.put("itemName", item.getName());
            orderDetails.put("quantity", item.getQuantity());
            orderDetails.put("price", item.getPrice());
            orderDetails.put("date", currentDateTime); // Save the date and time
            orderDetails.put("shippingLocation", shippingLocation); // Save shipping location

            orderDetailsList.add(orderDetails);
        }

        // Save the entire order details as a list
        orderRef.child("items").setValue(orderDetailsList).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(this, "Order saved to Firebase!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Failed to save order.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}