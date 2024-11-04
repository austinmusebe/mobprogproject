package com.example.mobprogproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText name; // This will be used to input any new order or data
    TextView username, orderHistoryTextView, shippingLocationTextView;
    FirebaseAuth mAuth;
    Button btnLogout, btnShopping, btnGoShopping;
    FirebaseUser user;
    private DatabaseReference databaseReference;
    private List<CartItem> orderHistory = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        username = findViewById(R.id.txtUserDetails);
        orderHistoryTextView = findViewById(R.id.orderHistoryTextView);
        shippingLocationTextView = findViewById(R.id.shippingLocationTextView);
        btnLogout = findViewById(R.id.btnLogout);
        btnShopping = findViewById(R.id.btnShipping);
        btnGoShopping = findViewById(R.id.btnGoShopping);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();  // Initialize Firebase database reference

        if (user == null) {
            Intent i = new Intent(MainActivity.this, Login.class);
            startActivity(i);
            finish();
        } else {
            username.setText(user.getEmail());
        }

        loadOrderHistory();  // Load order history on activity start
        loadShippingLocation();  // Load shipping location

        btnLogout.setOnClickListener(view -> {
            mAuth.signOut();
            Intent i = new Intent(MainActivity.this, Login.class);
            startActivity(i);
            finish();
        });

        btnGoShopping.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, categories.class);
            startActivity(i);
            finish();
        });

        btnShopping.setOnClickListener(view -> {
            Intent j = new Intent(MainActivity.this, Shipping.class);
            startActivity(j);
            finish();
        });
    }

    private void loadOrderHistory() {
        String userId = user.getUid();
        databaseReference.child("users").child(userId).child("orderHistory")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        orderHistory.clear();
                        StringBuilder history = new StringBuilder();
                        Log.d("FirebaseData", "Order History Snapshot: " + snapshot.toString());

                        if (snapshot.exists()) {
                            for (DataSnapshot orderSnapshot : snapshot.getChildren()) {
                                List<Map<String, Object>> orderItems = (List<Map<String, Object>>) orderSnapshot.child("items").getValue();

                                // Log to check what items are being retrieved
                                Log.d("FirebaseData", "Order Snapshot: " + orderSnapshot.toString());

                                if (orderItems != null) {
                                    for (Map<String, Object> item : orderItems) {
                                        String itemName = (String) item.get("itemName");
                                        Integer quantity = ((Long) item.get("quantity")).intValue(); // Convert Long to Integer
                                        Double price = ((Number) item.get("price")).doubleValue(); // Convert Number to Double
                                        String orderDate = orderSnapshot.child("date").getValue(String.class);
                                        String orderLocation = orderSnapshot.child("shippingLocation").getValue(String.class);

                                        // Append order item details to the history
                                        history.append("Item: ").append(itemName)
                                                .append(", Quantity: ").append(quantity)
                                                .append(", Price: $").append(price)
                                                .append(", Date: ").append(orderDate != null ? orderDate : "N/A")
                                                .append(", Location: ").append(orderLocation != null ? orderLocation : "N/A")
                                                .append("\n");
                                    }
                                }
                            }
                        } else {
                            history.append("No orders found.");
                        }

                        // Log the final history
                        Log.d("FirebaseData", "Order History Text: " + history.toString());
                        // Set the order history text
                        orderHistoryTextView.setText(history.toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(MainActivity.this, "Failed to load order history.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void loadShippingLocation() {
        String userId = mAuth.getCurrentUser().getUid();
        databaseReference.child("users").child(userId).child("shippingLocation")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String city = snapshot.getValue(String.class);
                        if (city != null) {
                            shippingLocationTextView.setText("Shipping Location: " + city);
                        } else {
                            shippingLocationTextView.setText("No shipping location set.");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(MainActivity.this, "Failed to load shipping location.", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
