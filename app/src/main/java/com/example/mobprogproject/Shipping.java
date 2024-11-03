package com.example.mobprogproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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

public class Shipping extends AppCompatActivity implements OnMapReadyCallback {

     MapView mapView;
     GoogleMap googleMap;
     RadioGroup radioGroup;
     RadioButton radio_address1, radio_address2, radio_address3;
     Button btnReturnToHome;
     LatLng address1 = new LatLng(37.7749, -122.4194); // Example: San Francisco
     LatLng address2 = new LatLng(34.0522, -118.2437); // Example: Los Angeles
     LatLng address3 = new LatLng(40.7128, -74.0060); // Example: New York

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shipping);

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this); // Register the callback

        radioGroup = findViewById(R.id.radiogroup);
        radio_address1 = findViewById(R.id.radioAddress1);
        radio_address2 = findViewById(R.id.radioAddress2);
        radio_address3 = findViewById(R.id.radioAddress3);
        btnReturnToHome = findViewById(R.id.btnReturnToHome);

        btnReturnToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Shipping.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (googleMap != null) {
                    LatLng selectedAddress;
                    if (checkedId == R.id.radioAddress1) {
                        selectedAddress = address1;
                    } else if (checkedId == R.id.radioAddress2) {
                        selectedAddress = address2;
                    } else if (checkedId == R.id.radioAddress3) {
                        selectedAddress = address3;
                    } else {
                        return;
                    }
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

    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;
    }

    private void updateMapLocation(LatLng location) {
        googleMap.clear(); // Clear previous markers
        googleMap.addMarker(new MarkerOptions().position(location).title("Selected Address"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 12f));
    }
}

