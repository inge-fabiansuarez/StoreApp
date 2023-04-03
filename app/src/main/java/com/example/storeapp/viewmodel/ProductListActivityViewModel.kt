package com.example.storeapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.storeapp.model.Product
import com.example.storeapp.view.ProductAdapter

class ProductListActivityViewModel : ViewModel() {

    val products: ArrayList<Product> = arrayListOf()
    var adapter: ProductAdapter = ProductAdapter(products);

    fun refreshData() {
        adapter.refresh(products)
    }

    fun loadProducts() {
        products.apply {
            clear()
            add(
                Product(
                    name = "Monitor",
                    price = 10000,
                    urlImage = "https://aprendelibvrefiles.blob.core.windows.net/aprendelibvre-container/course/informatica_basica/image/compescritorio-01_xl.png"
                )
            )
            add(
                Product(
                    name = "Teclado",
                    price = 302000,
                    urlImage = "https://aprendelibvrefiles.blob.core.windows.net/aprendelibvre-container/course/informatica_basica/image/compescritorio-01_xl.png"
                )
            )
            add(
                Product(
                    name = "Discoduro",
                    price = 25000,
                    urlImage = "https://aprendelibvrefiles.blob.core.windows.net/aprendelibvre-container/course/informatica_basica/image/compescritorio-01_xl.png"
                )
            )
        }
    }
}