package com.example.mobprogproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment {

    int shirtCount = 0;
    int trouserCount = 0;
    int shoesCount = 0;
    private final List<CartItem> cartItems = new ArrayList<>();
    Button btnViewAccount;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        TextView txtShirtCounter = view.findViewById(R.id.txtShirtCounter);
        ImageView addShirt = view.findViewById(R.id.addShirt);
        ImageView removeShirt = view.findViewById(R.id.removeShirt);
        Button btnShirt = view.findViewById(R.id.btnShirt);
        Button btnCart = view.findViewById(R.id.btnCart);
        btnViewAccount = view.findViewById(R.id.btnViewAccount);

        btnViewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);
                getActivity().finish();
            }
        });




        // Set up click listeners for the T-shirt item
        addShirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shirtCount++;
                txtShirtCounter.setText(String.valueOf(shirtCount));
            }
        });
        removeShirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shirtCount > 0) shirtCount--;
                txtShirtCounter.setText(String.valueOf(shirtCount));
            }
        });

        btnShirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemToCart("T-Shirt", shirtCount, 5.0);
            }
        });

        // Repeat similar setup for Trouser and Shoe items
        TextView txtTrouserCounter = view.findViewById(R.id.txtTrouserCounter);
        ImageView addTrouser = view.findViewById(R.id.addTrouser);
        ImageView removeTrouser = view.findViewById(R.id.removeTrouser);
        Button btnTrouser = view.findViewById(R.id.btnTrouser);

        addTrouser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trouserCount++;
                txtTrouserCounter.setText(String.valueOf(trouserCount));
            }
        });

        removeTrouser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (trouserCount > 0) trouserCount--;
                txtTrouserCounter.setText(String.valueOf(trouserCount));
            }
        });

        btnTrouser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemToCart("Trouser", trouserCount, 10);
            }
        });

        // Set up for shoes as well
        TextView txtShoeCounter = view.findViewById(R.id.txtShoeCounter);
        ImageView addShoe = view.findViewById(R.id.addShoe);
        ImageView removeShoe = view.findViewById(R.id.removeSoe);
        Button btnShoes = view.findViewById(R.id.btnShoes);

        addShoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoesCount++;
                txtShoeCounter.setText(String.valueOf(shoesCount));
            }
        });

        removeShoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shoesCount > 0) shoesCount--;
                txtShoeCounter.setText(String.valueOf(shoesCount));
            }
        });

        btnShoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemToCart("Shoe", shoesCount, 15);
            }
        });

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cartItems.isEmpty()) {
                    Toast.makeText(getContext(), "Cart is empty", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getActivity(), cart.class);
                    intent.putExtra("cartItems", (Serializable) cartItems);
                    startActivity(intent);
                }
            }
        });
    }
    private void addItemToCart(String itemName, int quantity, double price) {
        if (quantity > 0) {
            cartItems.add(new CartItem(itemName, quantity, price));
            Toast.makeText(getContext(), itemName + " added to cart", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getContext(), "Please increase the quantity", Toast.LENGTH_SHORT).show();
        }
    }
}

