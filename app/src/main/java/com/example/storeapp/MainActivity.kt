package com.example.storeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.storeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //1. creamos el objeto binding, el ActivityMainBinding se genero automaticamente cuando se configuro la libreria
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //2. relacionamos el loyout con la logica.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        val myClient: User = Client(name = "fabian@correo.com", password = "1234567")

        //agregar la informacion de las etiquedas data en el xml
        binding.title = "titulo"
        binding.user = myClient

        binding.btnLogin.setOnClickListener {
            if (binding.user?.name == "fabian" && binding.user?.password == "123456") {
                Toast.makeText(this, "Iniciar sesion", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Datos Incorrectos", Toast.LENGTH_SHORT).show()
            }

        }

    }
}