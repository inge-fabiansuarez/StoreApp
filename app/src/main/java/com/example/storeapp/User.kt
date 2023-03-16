package com.example.storeapp

abstract class User(val name: String, val password: String) {

    open fun login(): Boolean {
        return name == "fabian@correo.com" && password == "123"
    }

}