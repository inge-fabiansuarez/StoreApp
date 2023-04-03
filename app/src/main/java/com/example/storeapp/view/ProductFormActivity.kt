package com.example.storeapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.storeapp.R
import com.example.storeapp.databinding.ActivityProductAddBinding
import com.example.storeapp.model.entity.Product
import com.example.storeapp.viewmodel.ProductFormActivityViewModel

class ProductFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductAddBinding
    private lateinit var viewModel: ProductFormActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val myProduct: Product? = intent.getSerializableExtra("product") as Product?



        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_add)
        viewModel = ViewModelProvider(this)[ProductFormActivityViewModel::class.java]


        binding.viewModel = viewModel

        myProduct?.let {
            viewModel.product = it
            binding.btnAddAddproduct.text = "Editar producto"
            binding.btnAddAddproduct.setOnClickListener {
                viewModel.edit()
                finish()
            }
        } ?: run {
            binding.btnAddAddproduct.setOnClickListener {
                viewModel.insert()
                finish()
            }
        }

    }


}