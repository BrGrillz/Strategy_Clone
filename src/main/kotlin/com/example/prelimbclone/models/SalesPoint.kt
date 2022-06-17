package com.example.prelimbclone.models

data class SalesPoint(
    val sellerplaceCode: Int? = null,
    val sellerplaceTown: String? = null,
    val products: ArrayList<Products>? = null,
)
