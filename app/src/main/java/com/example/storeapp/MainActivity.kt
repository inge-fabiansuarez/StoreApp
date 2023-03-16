package com.example.storeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.storeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //1. creamos el objeto binding, el ActivityMainBinding se genero automaticamente cuando se configuro la libreria
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //2. relacionamos el loyout con la logica.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //val obj:User = Client(name = "fabian@correo.com", password = "546")



    }
}