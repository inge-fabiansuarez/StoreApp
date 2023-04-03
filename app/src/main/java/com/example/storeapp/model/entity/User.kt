package com.example.storeapp.model.entity

open class User(var name: String, var password: String) {

    open fun login(): Boolean {
        return name == "fabian@correo.com" && password == "123"
    }

}