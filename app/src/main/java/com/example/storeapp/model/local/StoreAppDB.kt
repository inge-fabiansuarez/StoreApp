package com.example.storeapp.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.storeapp.model.entity.Product
import com.example.storeapp.model.local.dao.ProductDAO

@Database(entities = [Product::class], version = 2, exportSchema = true)
abstract class StoreAppDB : RoomDatabase() {
    abstract fun productDAO(): ProductDAO

    companion object {
        private var INSTANCE: StoreAppDB? = null
        fun getInstance(myContext: Context): StoreAppDB {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(myContext, StoreAppDB::class.java, "storeapp_db")
                    .allowMainThreadQueries().build()
            }
            return INSTANCE as StoreAppDB
        }
    }
}