package com.ashraful.eseller.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ashraful.eseller.Models.Products;
import com.ashraful.eseller.ProductDetailsActivity;
import com.ashraful.eseller.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {
    private ArrayList<Products> listdata;
    private Context context;

    public ProductListAdapter(ArrayList<Products> listdata, Context context) {
        this.listdata = listdata;
        this.context = context;
    }
    @NonNull
    @Override
    public ProductListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_product, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListAdapter.ViewHolder holder, int position) {
        final Products product = listdata.get(position);
        holder.name.setText(product.getPname());
        holder.price.setText(product.getPrice());
        Glide.with(context)
                .load(product.getImage())
                .centerCrop()
                .into(holder.imageView);
        holder.imageView.setOnClickListener(view -> {
             Intent intent = new Intent(context, ProductDetailsActivity.class);
             intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
             intent.putExtra("name",product.getPname());
             intent.putExtra("description",product.getDescription());
             intent.putExtra("price",product.getPrice());
             intent.putExtra("image",product.getImage());
             intent.putExtra("id",product.getPid());
             context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView name,price,addToCart;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.iv_image);
            this.name = itemView.findViewById(R.id.tv_name);
            this.price = itemView.findViewById(R.id.tv_price);
           // this.addToCart = itemView.findViewById(R.id.tv_add_to_cart);

        }
    }

}
