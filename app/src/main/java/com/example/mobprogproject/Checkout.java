package com.example.mobprogproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Checkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_checkout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText custaddress;
        TextView deliverydetails,totalitems,totalamount;
        Button confirmorder;

        custaddress=findViewById(R.id.custaddress);
        deliverydetails=findViewById(R.id.deliverydetails);
        totalitems=findViewById(R.id.totalitems);
        totalamount=findViewById(R.id.totalamount);
        confirmorder=findViewById(R.id.confirmorder);

        


    }
}