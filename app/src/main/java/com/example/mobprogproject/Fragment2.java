package com.example.mobprogproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {

    Button btnBlackShirt, btnWhiteShirt, btnPinkDunks, btnCart2;
    List<CartItem> cartItems = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment2_layout,container
        ,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnBlackShirt = view.findViewById(R.id.btnBlackShirt);
        btnWhiteShirt = view.findViewById(R.id.btnWhiteShirt);
        btnPinkDunks = view.findViewById(R.id.btnPinkDunks);
        Button btnCart = view.findViewById(R.id.btnCart2);

        btnBlackShirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart("Black Shirt", 1, 15.00);
                Toast.makeText(getContext(),"Added to cart",Toast.LENGTH_SHORT).show();
            }
        });

        btnWhiteShirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart("White Shirt", 1, 10.00);
            }
        });

        btnPinkDunks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart("Pink Dunks", 1, 15.00);
            }
        });



    }

    private void addToCart(String itemName,int quantity, double price) {
        CartItem item = new CartItem(itemName, quantity, price);
        cartItems.add(item); // Add item to list
    }
    private void openCartActivity() {
        Intent intent = new Intent(getActivity(), cart.class);
        intent.putExtra("cartItems", (Serializable) cartItems); // Ensure key matches in cart activity
        startActivity(intent);
    }
}
