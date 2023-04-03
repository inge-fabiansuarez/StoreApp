package com.example.storeapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.storeapp.model.entity.Product
import com.example.storeapp.model.repository.ProductRepository
import com.example.storeapp.view.ProductAdapter

class ProductListActivityViewModel(application: Application) : AndroidViewModel(application) {


    private val productRepository: ProductRepository = ProductRepository(application)
    var products: LiveData<List<Product>> = productRepository.products

    fun deleteProduct(myProduct: Product) {
        productRepository.deleteLocal(myProduct)
    }


}