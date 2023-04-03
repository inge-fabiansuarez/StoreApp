package com.example.storeapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.storeapp.model.entity.Product
import com.example.storeapp.model.repository.ProductRepository

class ProductFormActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val repositoryProduct: ProductRepository = ProductRepository(application)
    var product: Product = Product(name = "", price = 0)

    fun insert() {
        repositoryProduct.insetLocal(myProduct = product)
    }
}