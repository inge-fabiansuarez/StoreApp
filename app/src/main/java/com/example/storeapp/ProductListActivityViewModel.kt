package com.example.storeapp

import androidx.lifecycle.ViewModel

class ProductListActivityViewModel: ViewModel() {

    val products:ArrayList<Product> = arrayListOf()
    var adapter:ProductAdapter = ProductAdapter(products);

    fun refreshData(){
        adapter.refresh(products)
    }

    fun loadProducts(){
        products.apply {
            clear()
            add(Product("Monitor",10000))
            add(Product("Teclado",302000))
            add(Product("Discoduro",25000))
            add(Product("Monitor",10000))
            add(Product("Teclado",302000))
            add(Product("Discoduro",25000))
            add(Product("Monitor",10000))
            add(Product("Teclado",302000))
            add(Product("Discoduro",25000))
            add(Product("Monitor",10000))
            add(Product("Teclado",302000))
            add(Product("Discoduro",25000))
            add(Product("Monitor",10000))
            add(Product("Teclado",302000))
            add(Product("Discoduro",25000))
            add(Product("Monitor",10000))
            add(Product("Teclado",302000))
            add(Product("Discoduro",25000))
        }
    }
}