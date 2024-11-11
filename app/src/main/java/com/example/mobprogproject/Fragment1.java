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
        TextView txtShirtCounter2 = view.findViewById(R.id.txtShirtCounter2);
        ImageView addShirt2 = view.findViewById(R.id.addShirt2);
        ImageView removeShirt2 = view.findViewById(R.id.removeShirt2);
        Button btnShirt2 = view.findViewById(R.id.btnShirt2);

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
                addItemToCart("T-Shirt", shirtCount, 20);
            }
        });

        //Second shirt
        addShirt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shirtCount++;
                txtShirtCounter2.setText(String.valueOf(shirtCount));
            }
        });
        removeShirt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shirtCount > 0) shirtCount--;
                txtShirtCounter2.setText(String.valueOf(shirtCount));
            }
        });

        btnShirt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemToCart("T-Shirt", shirtCount, 20);
            }
        });


        // Set up click listeners for Trouser
        TextView txtTrouserCounter = view.findViewById(R.id.txtTrouserCounter);
        ImageView addTrouser = view.findViewById(R.id.addTrouser);
        ImageView removeTrouser = view.findViewById(R.id.removeTrouser);
        Button btnTrouser = view.findViewById(R.id.btnTrouser);
        TextView txtTrouserCounter2 = view.findViewById(R.id.txtTrouserCounter2);
        ImageView addTrouser2 = view.findViewById(R.id.addTrouser2);
        ImageView removeTrouser2 = view.findViewById(R.id.removeTrouser2);
        Button btnTrouser2 = view.findViewById(R.id.btnTrouser2);

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
                addItemToCart("Trouser", trouserCount, 20);
            }
        });

        //Second trouser
        addTrouser2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trouserCount++;
                txtTrouserCounter2.setText(String.valueOf(trouserCount));
            }
        });

        removeTrouser2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (trouserCount > 0) trouserCount--;
                txtTrouserCounter2.setText(String.valueOf(trouserCount));
            }
        });

        btnTrouser2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemToCart("Trouser", trouserCount, 20);
            }
        });

        // Set up for shoes as well
        TextView txtShoeCounter = view.findViewById(R.id.txtShoeCounter);
        ImageView addShoe = view.findViewById(R.id.addShoe);
        ImageView removeShoe = view.findViewById(R.id.removeShoe);
        Button btnShoes = view.findViewById(R.id.btnShoes);
        TextView txtShoeCounter2 = view.findViewById(R.id.txtShoeCounter2);
        ImageView addShoe2 = view.findViewById(R.id.addShoe2);
        ImageView removeShoe2 = view.findViewById(R.id.removeShoe2);
        Button btnShoes2 = view.findViewById(R.id.btnShoes2);

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
                addItemToCart("Shoe", shoesCount, 20);
            }
        });

        //Second shoe
        addShoe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoesCount++;
                txtShoeCounter2.setText(String.valueOf(shoesCount));
            }
        });

        removeShoe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shoesCount > 0) shoesCount--;
                txtShoeCounter2.setText(String.valueOf(shoesCount));
            }
        });

        btnShoes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemToCart("Shoe", shoesCount, 20);
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

