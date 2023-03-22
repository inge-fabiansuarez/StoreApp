package com.example.storeapp

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    var user:User=User("", "")

    fun login():Boolean{
        return user.name == "fabian" && user.password == "123456"
    }

}