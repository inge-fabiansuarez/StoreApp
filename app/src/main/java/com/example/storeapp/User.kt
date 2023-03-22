package com.example.storeapp

open class User(var name: String, var password: String) {

    open fun login(): Boolean {
        return name == "fabian@correo.com" && password == "123"
    }

}