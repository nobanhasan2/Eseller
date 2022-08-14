package com.ashraful.eseller.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ashraful.eseller.CartActivity;
import com.ashraful.eseller.Models.Products;
import com.ashraful.eseller.ProductDetailsActivity;
import com.ashraful.eseller.R;
import com.ashraful.eseller.data.AppDatabase;
import com.ashraful.eseller.data.CartItem;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {
    private List<CartItem> listdata = new ArrayList();
    private Context context;

    private CallBackCart callBack;
    public CartListAdapter(List<CartItem> listdata, Context context,CallBackCart callBack) {
        this.listdata = listdata;
        this.context = context;
        this.callBack = callBack;

    }


    public void setItems(List<CartItem> listdata){
        listdata.addAll(listdata);
    }
    @NonNull
    @Override
    public CartListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_cart, parent, false);
        return new CartListAdapter.ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull CartListAdapter.ViewHolder holder, int position) {
        final CartItem product = listdata.get(position);
        holder.name.setText(product.getName());
        holder.price.setText(product.getPrice());
        Glide.with(context)
                .load(product.getImage())
                .centerCrop()
                .into(holder.imageView);
        holder.cancel.setOnClickListener(view -> callBack.onRemove(product));

    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView,cancel;
        public TextView name,price;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView2);
            this.name = itemView.findViewById(R.id.tv_cart_name);
            this.price = itemView.findViewById(R.id.tv_cart_price);
            this.cancel = itemView.findViewById(R.id.iv_remove);

        }
    }

}
