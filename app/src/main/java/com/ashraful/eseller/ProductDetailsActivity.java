package com.ashraful.eseller;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ashraful.eseller.Models.Products;
import com.ashraful.eseller.data.AppDatabase;
import com.ashraful.eseller.data.AppExecutors;
import com.ashraful.eseller.data.CartItem;
import com.bumptech.glide.Glide;

public class ProductDetailsActivity extends AppCompatActivity {


    String name,image,price,id,description;

    ImageView imageView;
    TextView tvName,tvDescription,tvPrice;
    Button addToCart;
    private AppDatabase mDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        addToCart = findViewById(R.id.bt_add_to_cart);
        tvName = findViewById(R.id.tv_d_name);
        tvDescription =  findViewById(R.id.tv_d_details);
        tvPrice =  findViewById(R.id.tv_d_price);
        imageView =  findViewById(R.id.imageView);

        name = getIntent().getExtras().getString("name");
        image = getIntent().getExtras().getString("image");
        price = getIntent().getExtras().getString("price");
        id = getIntent().getExtras().getString("id");
        description = getIntent().getExtras().getString("description");

        mDb = AppDatabase.getInstance(getApplicationContext());
        tvName.setText(name);
        Glide.with(this).load(image).into(imageView);
        tvPrice.setText("BDT "+price);
        tvDescription.setText("Details : "+description);
        addToCart.setOnClickListener(view -> AppExecutors.getInstance().diskIO().execute(() ->
                mDb.productsDao().insertPerson(new CartItem(id,name,image,price))));


    }
}