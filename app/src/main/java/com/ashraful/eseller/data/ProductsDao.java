package com.ashraful.eseller.data;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.ashraful.eseller.Models.Products;

import java.util.List;

@Dao
public interface ProductsDao {
    @Query("SELECT * FROM cart_item ORDER BY id")
    List<CartItem> loadAppProducts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPerson(CartItem products);

    @Update
    void updateCart(CartItem products);

    @Delete
    void delete(CartItem products);

    @Query("SELECT * FROM cart_item WHERE id = :id")
    CartItem loadCartById(int id);
}
