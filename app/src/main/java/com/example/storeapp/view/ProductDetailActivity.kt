package com.example.storeapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.storeapp.R
import com.example.storeapp.databinding.ActivityProductDetailBinding
import com.example.storeapp.model.entity.Product
import com.example.storeapp.viewmodel.ProductDetailActivityViewModel

class ProductDetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityProductDetailBinding
    lateinit var viewModel: ProductDetailActivityViewModel
    var myProductKey: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myProductKey = intent.getIntExtra("keyProduct", 0)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_detail)
        viewModel = ViewModelProvider(this)[ProductDetailActivityViewModel::class.java]

        viewModel.getProductByKey(myProductKey)


        binding.product = viewModel.product

        binding.btnEditarDetail.setOnClickListener {
            var intentEditar = Intent(applicationContext, ProductFormActivity::class.java)
            intentEditar.putExtra("product", viewModel.product)
            startActivity(intentEditar)
        }

    }

    override fun onResume() {
        viewModel.getProductByKey(myProductKey)
        binding.product = viewModel.product
        super.onResume()
    }
}