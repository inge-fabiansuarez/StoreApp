package com.example.storeapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.storeapp.model.entity.Product
import com.example.storeapp.model.repository.ProductRepository

class ProductDetailActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val productRepository: ProductRepository = ProductRepository(application)
    var product = Product(name = "", price = 0)
    fun getProductByKey(myProductKey: Int) {
       // product = productRepository.getByKeyLocal(myProductKey)
    }


}