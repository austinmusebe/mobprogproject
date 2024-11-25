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
    int shirtCount2 = 0;
    int trouserCount = 0;
    int shortCount = 0;
    int shoeCount = 0;
    int shoeCount2 = 0;
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

        addShirt.setVisibility(View.INVISIBLE);
        removeShirt.setVisibility(View.INVISIBLE);
        txtShirtCounter.setVisibility(View.INVISIBLE);

        btnViewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);
                getActivity().finish();
            }
        });


        // Set up click listeners for the T-shirt item
        btnShirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hide Add to Cart button and show counter and + and - buttons
                btnShirt.setVisibility(View.GONE);
                addShirt.setVisibility(View.VISIBLE);
                removeShirt.setVisibility(View.VISIBLE);
                txtShirtCounter.setVisibility(View.VISIBLE);

                // Start the counter at 1
                shirtCount = 1;
                txtShirtCounter.setText(String.valueOf(shirtCount));
                addItemToCart("White T-Shirt", shirtCount, 20);
            }
        });

        addShirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increment the counter
                shirtCount++;
                txtShirtCounter.setText(String.valueOf(shirtCount));
                updateCart("White T-Shirt", shirtCount);
            }
        });

        removeShirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //reset UI if count reaches 0
                if (shirtCount > 1) {
                    shirtCount--;
                    txtShirtCounter.setText(String.valueOf(shirtCount));
                    updateCart("White T-Shirt", shirtCount);
                } else {
                    shirtCount = 0;
                    removeFromCart("White T-Shirt");

                    // Reset the UI
                    txtShirtCounter.setVisibility(View.GONE);
                    addShirt.setVisibility(View.GONE);
                    removeShirt.setVisibility(View.GONE);
                    btnShirt.setVisibility(View.VISIBLE);
                }
            }
        });



        //Second shirt
        btnShirt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnShirt2.setVisibility(View.GONE);
                addShirt2.setVisibility(View.VISIBLE);
                removeShirt2.setVisibility(View.VISIBLE);
                txtShirtCounter2.setVisibility(View.VISIBLE);

                // Start the counter at 1
                shirtCount2 = 1;
                txtShirtCounter2.setText(String.valueOf(shirtCount2));
                addItemToCart("Black T-Shirt", shirtCount2, 20);
            }
        });

        addShirt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increment the counter
                shirtCount2++;
                txtShirtCounter2.setText(String.valueOf(shirtCount2));
                updateCart("Black T-Shirt", shirtCount2);
            }
        });

        removeShirt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (shirtCount2 > 1) {
                    shirtCount2--;
                    txtShirtCounter2.setText(String.valueOf(shirtCount2));
                    updateCart("Black T-Shirt", shirtCount2);
                } else {
                    shirtCount2 = 0;
                    removeFromCart("Black T-Shirt");

                    // Reset the UI
                    txtShirtCounter2.setVisibility(View.GONE);
                    addShirt2.setVisibility(View.GONE);
                    removeShirt2.setVisibility(View.GONE);
                    btnShirt2.setVisibility(View.VISIBLE);
                }
            }
        });



        // Set up click listeners for Trouser
        TextView txtTrouserCounter = view.findViewById(R.id.txtTrouserCounter);
        ImageView addTrouser = view.findViewById(R.id.addTrouser);
        ImageView removeTrouser = view.findViewById(R.id.removeTrouser);
        Button btnTrouser = view.findViewById(R.id.btnTrouser);
        TextView txtShortCounter = view.findViewById(R.id.txtShortCounter);
        ImageView addShort = view.findViewById(R.id.addShort);
        ImageView removeShort = view.findViewById(R.id.removeShort);
        Button btnShort = view.findViewById(R.id.btnShort);

        btnTrouser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTrouser.setVisibility(View.GONE);
                addTrouser.setVisibility(View.VISIBLE);
                removeTrouser.setVisibility(View.VISIBLE);
                txtTrouserCounter.setVisibility(View.VISIBLE);

                trouserCount = 1;
                txtTrouserCounter.setText(String.valueOf(trouserCount));
                addItemToCart("Trousers", trouserCount, 20);
            }
        });

        addTrouser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                trouserCount++;
                txtTrouserCounter.setText(String.valueOf(trouserCount));
                updateCart("Trousers", trouserCount);
            }
        });

        removeTrouser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (trouserCount > 1) {
                    trouserCount--;
                    txtTrouserCounter.setText(String.valueOf(trouserCount));
                    updateCart("Trousers", trouserCount);
                } else {
                    trouserCount = 0;
                    removeFromCart("Trousers");

                    // Reset the UI
                    txtTrouserCounter.setVisibility(View.GONE);
                    addTrouser.setVisibility(View.GONE);
                    removeTrouser.setVisibility(View.GONE);
                    btnTrouser.setVisibility(View.VISIBLE);
                }
            }
        });

        //Shorts
        btnShort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnShort.setVisibility(View.GONE);
                addShort.setVisibility(View.VISIBLE);
                removeShort.setVisibility(View.VISIBLE);
                txtShortCounter.setVisibility(View.VISIBLE);


                shortCount = 1;
                txtShortCounter.setText(String.valueOf(shortCount));
                addItemToCart("Shorts", shortCount, 20);
            }
        });

        addShort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                shortCount++;
                txtShortCounter.setText(String.valueOf(shortCount));
                updateCart("Shorts", shortCount);
            }
        });

        removeShort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (shortCount > 1) {
                    shortCount--;
                    txtShortCounter.setText(String.valueOf(shortCount));
                    updateCart("Shorts", shortCount);
                } else {
                    shortCount = 0;
                    removeFromCart("Shorts");

                    // Reset the UI
                    txtShortCounter.setVisibility(View.GONE);
                    addShort.setVisibility(View.GONE);
                    removeShort.setVisibility(View.GONE);
                    btnShort.setVisibility(View.VISIBLE);
                }
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


        btnShoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnShoes.setVisibility(View.GONE);
                addShoe.setVisibility(View.VISIBLE);
                removeShoe.setVisibility(View.VISIBLE);
                txtShoeCounter.setVisibility(View.VISIBLE);

                // Initialize counter to 1
                shoeCount = 1;
                txtShoeCounter.setText(String.valueOf(shoeCount));
                addItemToCart("Shoes", shoeCount, 20);
            }
        });


        addShoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increment the counter
                shoeCount++;
                txtShoeCounter.setText(String.valueOf(shoeCount));
                updateCart("Shoes", shoeCount);
            }
        });


        removeShoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (shoeCount > 1) {
                    shoeCount--;
                    txtShoeCounter.setText(String.valueOf(shoeCount));
                    updateCart("Shoes", shoeCount);
                } else {
                    shoeCount = 0;
                    removeFromCart("Shoes");


                    txtShoeCounter.setVisibility(View.GONE);
                    addShoe.setVisibility(View.GONE);
                    removeShoe.setVisibility(View.GONE);
                    btnShoes.setVisibility(View.VISIBLE);
                }
            }
        });

        // Add to Cart Button
        btnShoes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnShoes2.setVisibility(View.GONE);
                addShoe2.setVisibility(View.VISIBLE);
                removeShoe2.setVisibility(View.VISIBLE);
                txtShoeCounter2.setVisibility(View.VISIBLE);

                // Initialize counter to 1
                shoeCount2 = 1;
                txtShoeCounter2.setText(String.valueOf(shoeCount2));
                addItemToCart("Leather Shoes", shoeCount2, 20);
            }
        });


        addShoe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                shoeCount2++;
                txtShoeCounter2.setText(String.valueOf(shoeCount2));
                updateCart("Leather Shoes", shoeCount2);
            }
        });


        removeShoe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (shoeCount2 > 1) {
                    shoeCount2--;
                    txtShoeCounter2.setText(String.valueOf(shoeCount2));
                    updateCart("Leather Shoes", shoeCount2);
                } else {
                    shoeCount2 = 0;
                    removeFromCart("Leather Shoes");

                    txtShoeCounter2.setVisibility(View.GONE);
                    addShoe2.setVisibility(View.GONE);
                    removeShoe2.setVisibility(View.GONE);
                    btnShoes2.setVisibility(View.VISIBLE);
                }
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



    private void addItemToCart(String itemName, int currentQuantity, double price) {
        if (currentQuantity > 0) {
            boolean itemExists = false;

            // Check if the item already exists in the cart
            for (CartItem item : cartItems) {
                if (item.getName().equals(itemName)) {
                    item.setQuantity(currentQuantity);
                    itemExists = true;
                    break;
                }
            }

            // If the item doesn't exist, add a new one
            if (!itemExists) {
                cartItems.add(new CartItem(itemName, currentQuantity, price));
            }

            Toast.makeText(getContext(), itemName + " added to cart", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Please increase the quantity", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateCart(String itemName, int newQuantity) {
        for (CartItem item : cartItems) {
            if (item.getName().equals(itemName)) {
                item.setQuantity(newQuantity);
                break;
            }
        }
    }

    // Helper to remove item from cart
    private void removeFromCart(String itemName) {
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getName().equals(itemName)) {
                cartItems.remove(i);
                break;
            }
        }
    }
}

