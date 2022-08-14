package com.ashraful.eseller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ashraful.eseller.adapter.CallBackCart;
import com.ashraful.eseller.adapter.CartListAdapter;
import com.ashraful.eseller.adapter.ProductListAdapter;
import com.ashraful.eseller.data.AppDatabase;
import com.ashraful.eseller.data.AppExecutors;
import com.ashraful.eseller.data.CartItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class CartActivity extends AppCompatActivity implements CallBackCart {

    private CartListAdapter adapter ;
    private RecyclerView recyclerView;
    private List<CartItem> cartItems = new  ArrayList();
    private AppDatabase mDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        mDb = AppDatabase.getInstance(getApplicationContext());
        recyclerView = findViewById(R.id.rv_cart);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartItems = mDb.productsDao().loadAppProducts();
        adapter = new CartListAdapter(cartItems,this,this);

        recyclerView.setAdapter(adapter);




    }


    @Override
    public void onRemove(CartItem cartItem) {
        mDb.productsDao().delete(cartItem);
        cartItems = mDb.productsDao().loadAppProducts();
        adapter = new CartListAdapter(cartItems,this,this);

        recyclerView.setAdapter(adapter);

    }
}