package com.example.mobprogproject;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CheckoutActivity extends AppCompatActivity {
    EditText editTextPhone;
    Button btnConfirmPayment;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        editTextPhone = findViewById(R.id.editTextPhone);
        btnConfirmPayment = findViewById(R.id.btnConfirmPayment);
        progressBar = findViewById(R.id.progressBar);

        btnConfirmPayment.setOnClickListener(view -> {
            String phone = editTextPhone.getText().toString();

            if (phone.isEmpty()) {
                Toast.makeText(CheckoutActivity.this, "Please enter your phone number.", Toast.LENGTH_SHORT).show();
                return;
            }

            progressBar.setVisibility(View.VISIBLE);
            btnConfirmPayment.setEnabled(false);

            // Simulate confirmation process
            new Handler().postDelayed(() -> {
                progressBar.setVisibility(View.GONE);
                btnConfirmPayment.setEnabled(true);
                Toast.makeText(CheckoutActivity.this, "Order confirmed! Phone: " + phone, Toast.LENGTH_SHORT).show();
                finish();
            }, 45000); // Delay for 45 seconds
        });
    }
}
