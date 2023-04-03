package com.example.storeapp.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.storeapp.model.ProductStatus

@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true) var key: Int? = null,
    var name: String,
    var price: Int,
    var description: String = "",
    @ColumnInfo(name = "url_image") var urlImage: String = "",
    var status: ProductStatus = ProductStatus.AVAILABLE
) : java.io.Serializable {


}