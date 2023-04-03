package com.example.storeapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.storeapp.model.entity.User

class MainActivityViewModel : ViewModel() {

    var user: User = User("", "")

    fun login():Boolean{
        return user.name == "fabian" && user.password == "123456"
    }

}