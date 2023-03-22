package com.example.storeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.storeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //1. creamos el objeto binding, el ActivityMainBinding se genero automaticamente cuando se configuro la libreria
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //2. relacionamos el loyout con la logica.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        //asignaciones para el binding
        binding.title = "titulo"
        binding.viewModel = viewModel

        binding.btnLogin.setOnClickListener {
            if (viewModel.login()) {
                Toast.makeText(this, "Iniciar sesion", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Datos Incorrectos", Toast.LENGTH_SHORT).show()
            }

        }

    }
}