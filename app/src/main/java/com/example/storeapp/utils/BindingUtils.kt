package com.example.storeapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseMethod
import com.bumptech.glide.Glide
import com.example.storeapp.R


@BindingAdapter("image")
fun loadImagen(imageView: ImageView, url: String) {
    Glide
        .with(imageView.context)
        .load(url)
        .centerCrop()
        .placeholder(R.drawable.ic_launcher_foreground)
        .into(imageView);
}

@InverseMethod("stringToInt")
fun intToString(value: Int): String {
    return value.toString()
}

@InverseMethod("intToString")
fun stringToInt(value: String): Int {
    return Integer.parseInt(value)
}