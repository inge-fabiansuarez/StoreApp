package com.example.storeapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.storeapp.model.entity.Product
import com.example.storeapp.model.repository.ProductRepository
import com.example.storeapp.view.ProductAdapter

class ProductListActivityViewModel(application: Application) : AndroidViewModel(application) {

    var products: ArrayList<Product> = arrayListOf()
    var adapter: ProductAdapter = ProductAdapter(products);
    private val productRepository: ProductRepository = ProductRepository(application)

    init {
        loadProducts()
    }

    fun refreshData() {
        loadProducts()
        adapter.refresh(products)
    }

    fun loadProducts() {
        products = productRepository.getAllLocal()
    }

    fun deleteProduct(myProduct: Product) {
        productRepository.deleteLocal(myProduct)
        loadProducts()
    }
}