package com.example.storeapp.model.local.dao

import androidx.room.*
import com.example.storeapp.model.entity.Product

@Dao
interface ProductDAO {

    @Query("select * from products")
    fun getAll(): List<Product>

    @Query("select * from products where key = :keyValue")
    fun getByKey(keyValue: Int): Product

    @Insert
    fun inset(myProduct: Product)

    @Update
    fun update(myProduct: Product)

    @Delete
    fun delete(myProduct: Product)
}