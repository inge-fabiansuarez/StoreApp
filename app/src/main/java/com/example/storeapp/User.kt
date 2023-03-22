package com.example.storeapp

abstract class User(var name: String, var password: String) {

    open fun login(): Boolean {
        return name == "fabian@correo.com" && password == "123"
    }

}