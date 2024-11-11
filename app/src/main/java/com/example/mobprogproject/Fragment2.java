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

public class Fragment2 extends Fragment {

    int shirtCount = 0;
    int shoesCount = 0;
    private final List<CartItem> cartItems = new ArrayList<>();
    Button btnViewAccount;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment2_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        TextView txtBlackShirtCounter1 = view.findViewById(R.id.txtBlackShirtCounter1);
        ImageView addBlackShirt1 = view.findViewById(R.id.addBlackShirt1);
        ImageView removeBlackShirt1 = view.findViewById(R.id.removeBlackShirt1);
        Button btnBlackShirt1 = view.findViewById(R.id.btnBlackShirt1);
        Button btnCart = view.findViewById(R.id.btnCart);
        btnViewAccount = view.findViewById(R.id.btnViewAccount);
        TextView txtBlackShirtCounter2 = view.findViewById(R.id.txtBlackShirtCounter2);
        ImageView addBlackShirt2 = view.findViewById(R.id.addBlackShirt2);
        ImageView removeBlackShirt2 = view.findViewById(R.id.removeBlackShirt2);
        Button btnBlackShirt2 = view.findViewById(R.id.btnBlackShirt2);

        btnViewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);
                getActivity().finish();
            }
        });


        // Set up click listeners for the Black T-shirt item
        addBlackShirt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shirtCount++;
                txtBlackShirtCounter1.setText(String.valueOf(shirtCount));
            }
        });
        removeBlackShirt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shirtCount > 0) shirtCount--;
                txtBlackShirtCounter1.setText(String.valueOf(shirtCount));
            }
        });
        btnBlackShirt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemToCart("Shirt", shirtCount, 20);
            }
        });

        //Second shirt
        addBlackShirt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shirtCount++;
                txtBlackShirtCounter2.setText(String.valueOf(shirtCount));
            }
        });
        removeBlackShirt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shirtCount > 0) shirtCount--;
                txtBlackShirtCounter2.setText(String.valueOf(shirtCount));
            }
        });

        btnBlackShirt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemToCart("Shirt", shirtCount, 20);
            }
        });


        // Set up click listeners for White T-shirt
        TextView txtWhiteShirtCounter1 = view.findViewById(R.id.txtWhiteShirtCounter1);
        ImageView addWhiteShirt1 = view.findViewById(R.id.addWhiteShirt1);
        ImageView removeWhiteShirt1 = view.findViewById(R.id.removeWhiteShirt1);
        Button btnWhiteShirt1 = view.findViewById(R.id.btnWhiteShirt1);
        TextView txtWhiteShirtCounter2 = view.findViewById(R.id.txtWhiteShirtCounter2);
        ImageView addWhiteShirt2 = view.findViewById(R.id.addWhiteShirt2);
        ImageView removeWhiteShirt2 = view.findViewById(R.id.removeWhiteShirt2);
        Button btnWhiteShirt2 = view.findViewById(R.id.btnWhiteShirt2);

        addWhiteShirt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shirtCount++;
                txtWhiteShirtCounter1.setText(String.valueOf(shirtCount));
            }
        });

        removeWhiteShirt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shirtCount > 0) shirtCount--;
                txtWhiteShirtCounter1.setText(String.valueOf(shirtCount));
            }
        });

        btnWhiteShirt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemToCart("Shirt", shirtCount, 20);
            }
        });

        //Second trouser
        addWhiteShirt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shirtCount++;
                txtWhiteShirtCounter2.setText(String.valueOf(shirtCount));
            }
        });

        removeWhiteShirt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shirtCount > 0) shirtCount--;
                txtWhiteShirtCounter2.setText(String.valueOf(shirtCount));
            }
        });

        btnWhiteShirt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemToCart("Shirt", shirtCount, 20);
            }
        });

        // Set up for shoes as well
        TextView txtPinkDunksCounter1 = view.findViewById(R.id.txtPinkDunksCounter1);
        ImageView addPinkDunks1 = view.findViewById(R.id.addPinkDunks1);
        ImageView removePinkDunks1 = view.findViewById(R.id.removePinkDunks1);
        Button btnPinkDunks1 = view.findViewById(R.id.btnPinkDunks1);
        TextView txtPinkDunksCounter2 = view.findViewById(R.id.txtPinkDunksCounter2);
        ImageView addPinkDunks2 = view.findViewById(R.id.addPinkDunks2);
        ImageView removePinkDunks2 = view.findViewById(R.id.removePinkDunks2);
        Button btnPinkDunks2 = view.findViewById(R.id.btnPinkDunks2);

        addPinkDunks1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoesCount++;
                txtPinkDunksCounter1.setText(String.valueOf(shoesCount));
            }
        });

        removePinkDunks1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shoesCount > 0) shoesCount--;
                txtPinkDunksCounter1.setText(String.valueOf(shoesCount));
            }
        });

        btnPinkDunks1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemToCart("Shoe", shoesCount, 20);
            }
        });

        //Second shoe
        addPinkDunks1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoesCount++;
                txtPinkDunksCounter2.setText(String.valueOf(shoesCount));
            }
        });

        removePinkDunks2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shoesCount > 0) shoesCount--;
                txtPinkDunksCounter2.setText(String.valueOf(shoesCount));
            }
        });

        btnPinkDunks2.setOnClickListener(new View.OnClickListener() {
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

