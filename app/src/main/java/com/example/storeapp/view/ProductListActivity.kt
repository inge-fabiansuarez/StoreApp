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

class ProductListActivity : AppCompatActivity() {

    lateinit var binding: ActivityProductListBinding
    lateinit var viewModel: ProductListActivityViewModel
    lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_list)
        viewModel = ViewModelProvider(this)[ProductListActivityViewModel::class.java]



        adapter = ProductAdapter(viewModel.products)

        binding.adapter = adapter

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
            adapter.refresh(viewModel.products)
            binding.rvProductsListProducts.adapter = adapter
            Toast.makeText(applicationContext, "Se elimino el " + it.name, Toast.LENGTH_SHORT)
                .show()
        }

    }

    override fun onResume() {
        super.onResume()
        viewModel.loadProducts()
        adapter.refresh(viewModel.products)
    }
}