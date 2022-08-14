package com.ashraful.eseller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ashraful.eseller.Models.Products;
import com.ashraful.eseller.adapter.CartListAdapter;
import com.ashraful.eseller.adapter.ProductListAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity
{
    private Button LogoutBtn;
    private RecyclerView recyclerView;
    private FirebaseDatabase database;
    private DatabaseReference productsReference=null;
    private final ArrayList<Products> products = new ArrayList();
    private ProductListAdapter adapter ;
    private Button cartList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        LogoutBtn = findViewById(R.id.logout_btn);
        cartList = findViewById(R.id.bt_cart);
        database = FirebaseDatabase.getInstance();
        productsReference = database.getReference("Products");

        recyclerView = findViewById(R.id.rv_products);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        getProducts();

        LogoutBtn.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);
        });
        cartList.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, CartActivity.class);
            startActivity(intent);
        });
    }

    private void getProducts() {
        productsReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Products product = postSnapshot.getValue(Products.class);
                    products.add(product);

                }

                adapter = new ProductListAdapter(products,getApplicationContext());
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}