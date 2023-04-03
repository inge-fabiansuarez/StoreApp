package com.example.storeapp.model.repository

import android.content.Context
import com.example.storeapp.model.entity.Product
import com.example.storeapp.model.local.StoreAppDB
import com.example.storeapp.model.local.dao.ProductDAO

class ProductRepository(myContext: Context) {

    private val db: StoreAppDB = StoreAppDB.getInstance(myContext)
    private val productDAO: ProductDAO = db.productDAO()
    private var products: ArrayList<Product> = arrayListOf()

    fun getAllLocal(): ArrayList<Product> {
        loadAllLocal()
        return products
    }

    fun loadAllLocal() {
        products = productDAO.getAll() as ArrayList<Product>
        if (products.isEmpty()) {
            loadFakeData()
        }
    }

    private fun loadFakeData() {

        productDAO.apply {
            inset(
                Product(
                    name = "Monitor",
                    price = 10000,
                    urlImage = "https://aprendelibvrefiles.blob.core.windows.net/aprendelibvre-container/course/informatica_basica/image/compescritorio-01_xl.png"
                )
            )
            inset(
                Product(
                    name = "Teclado",
                    price = 302000,
                    urlImage = "https://aprendelibvrefiles.blob.core.windows.net/aprendelibvre-container/course/informatica_basica/image/compescritorio-01_xl.png"
                )
            )
            inset(
                Product(
                    name = "Discoduro",
                    price = 25000,
                    urlImage = "https://aprendelibvrefiles.blob.core.windows.net/aprendelibvre-container/course/informatica_basica/image/compescritorio-01_xl.png"
                )
            )
        }
        loadAllLocal()

    }

    fun getByKeyLocal(key: Int): Product {
        return productDAO.getByKey(key)
    }

    fun insetLocal(myProduct: Product) {
        productDAO.inset(myProduct)
        loadAllLocal()
    }

    fun updateLocal(myProduct: Product) {
        productDAO.update(myProduct)
        loadAllLocal()
    }

    fun deleteLocal(myProduct: Product) {
        productDAO.delete(myProduct)
        loadAllLocal()
    }
}