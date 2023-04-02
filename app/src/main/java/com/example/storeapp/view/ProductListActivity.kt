package com.example.storeapp.view

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_list)
        viewModel = ViewModelProvider(this)[ProductListActivityViewModel::class.java]

        binding.viewModel = viewModel

        viewModel.loadProducts()

        viewModel.refreshData()

        viewModel.adapter.onItemClickListener = {
            Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT).show()
        }

    }
}