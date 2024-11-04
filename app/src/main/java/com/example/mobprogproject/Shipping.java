package com.example.mobprogproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Shipping extends AppCompatActivity implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap googleMap;
    private RadioGroup radioGroup;
    private RadioButton radio_address1, radio_address2, radio_address3;
    private Button btnReturnToHome;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;

    private final LatLng address1 = new LatLng(37.7749, -122.4194); // Example: San Francisco
    private final LatLng address2 = new LatLng(34.0522, -118.2437); // Example: Los Angeles
    private final LatLng address3 = new LatLng(40.7128, -74.0060); // Example: New York
    private final String[] cities = {"San Francisco", "Los Angeles", "New York"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shipping);

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        radioGroup = findViewById(R.id.radiogroup);
        radio_address1 = findViewById(R.id.radioAddress1);
        radio_address2 = findViewById(R.id.radioAddress2);
        radio_address3 = findViewById(R.id.radioAddress3);
        btnReturnToHome = findViewById(R.id.btnReturnToHome);

        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        btnReturnToHome.setOnClickListener(view -> {
            String selectedCity = getSelectedCity(); // Get the selected city
            if (selectedCity != null) {
                saveShippingLocation(selectedCity); // Save the selected city
            } else {
                Toast.makeText(Shipping.this, "Please select a shipping address.", Toast.LENGTH_SHORT).show();
                return; // Don't proceed if no city is selected
            }
            Intent i = new Intent(Shipping.this, MainActivity.class);
            startActivity(i);
            finish();
        });

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (googleMap != null) {
                LatLng selectedAddress = getSelectedAddress();
                if (selectedAddress != null) {
                    updateMapLocation(selectedAddress);
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void saveShippingLocation(String city) {
        String userId = mAuth.getCurrentUser().getUid();
        DatabaseReference shippingRef = databaseReference.child("users").child(userId).child("shippingLocation");

        // Save the shipping location in Firebase
        shippingRef.setValue(city).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(this, "Shipping location saved!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Failed to save shipping location.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateMapLocation(LatLng location) {
        googleMap.clear();
        googleMap.addMarker(new MarkerOptions().position(location).title("Selected Location"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15));
    }

    @Override
    public void onMapReady(GoogleMap map) {
        this.googleMap = map;
        updateMapLocation(address1);  // Default location
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    private String getSelectedCity() {
        if (radio_address1.isChecked()) return cities[0];
        if (radio_address2.isChecked()) return cities[1];
        if (radio_address3.isChecked()) return cities[2];
        return null; // Return null if no address is selected
    }

    private LatLng getSelectedAddress() {
        if (radio_address1.isChecked()) return address1;
        if (radio_address2.isChecked()) return address2;
        if (radio_address3.isChecked()) return address3;
        return null; // Return null if no address is selected
    }
}
