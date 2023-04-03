package com.example.storeapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.storeapp.model.entity.Product

class ProductDetailActivityViewModel : ViewModel() {

    var product = Product(name = "", price = 0)

}