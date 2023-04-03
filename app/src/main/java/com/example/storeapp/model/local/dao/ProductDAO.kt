package com.example.storeapp.model.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.storeapp.model.entity.Product

@Dao
interface ProductDAO {

    @Query("select * from products")
    fun getAll(): LiveData<List<Product>>

    @Query("select * from products where key = :keyValue")
    fun getByKey(keyValue: Int): LiveData<Product>

    @Insert
    fun inset(myProduct: Product)

    @Update
    fun update(myProduct: Product)

    @Delete
    fun delete(myProduct: Product)
}