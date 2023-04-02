package com.example.storeapp.model

data class Product(
    var name: String,
    var price: Int,
    var description: String ="",
    var status: ProductStatus = ProductStatus.AVAILABLE
) {


}