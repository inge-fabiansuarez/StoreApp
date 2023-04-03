package com.example.storeapp.model.entity

class Client(cart: ArrayList<Product>? = arrayListOf(), name: String, password: String) :
    User(name, password) {
}