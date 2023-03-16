package com.example.storeapp

enum class ProductStatus(val value: Int) {
    AVAILABLE(1), SENT(2), SOLD(3);

    fun description(): String {
        return when (this) {
            AVAILABLE -> "DISPONIBLE"
            SENT -> "ENVIADO"
            SOLD -> "VENDIDO"
        }
    }
}