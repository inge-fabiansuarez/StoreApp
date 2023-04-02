package com.example.storeapp.model

class Client(cart: ArrayList<Product>? = arrayListOf(), name: String, password: String) :
    User(name, password) {
}