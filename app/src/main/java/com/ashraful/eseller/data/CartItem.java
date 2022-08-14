package com.ashraful.eseller.data;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cart_item")
public class CartItem {

    @PrimaryKey
    @NonNull
    String id;
    String name,image,price;

    public CartItem(String id, String name, String image, String price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
