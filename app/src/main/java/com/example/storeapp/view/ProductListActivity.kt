package com.example.storeapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.storeapp.viewmodel.ProductListActivityViewModel
import com.example.storeapp.R
import com.example.storeapp.databinding.ActivityProductListBinding
import com.example.storeapp.model.entity.Product

class ProductListActivity : AppCompatActivity() {

    lateinit var binding: ActivityProductListBinding
    lateinit var viewModel: ProductListActivityViewModel
    lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_list)
        viewModel = ViewModelProvider(this)[ProductListActivityViewModel::class.java]



        adapter = ProductAdapter(arrayListOf())

        binding.adapter = adapter

        viewModel.products.observe(this) {
            adapter.refresh(it as ArrayList<Product>)
        }

        binding.btnAddProductListProduct.setOnClickListener {
            startActivity(Intent(this, ProductFormActivity::class.java))
        }

        adapter.onItemClickListener = {

            var intentDetalle = Intent(applicationContext, ProductDetailActivity::class.java)
            intentDetalle.putExtra("keyProduct", it.key)
            startActivity(intentDetalle)
        }

        adapter.onItemLongClickListener = {
            viewModel.deleteProduct(myProduct = it)
            binding.rvProductsListProducts.adapter = adapter
            Toast.makeText(applicationContext, "Se elimino el " + it.name, Toast.LENGTH_SHORT)
                .show()
        }

    }

    fun loadProducts() {
        viewModel.products.observe(this) {
            adapter.refresh(it as ArrayList<Product>)
        }
    }

    override fun onResume() {
        super.onResume()
        loadProducts()
    }
}