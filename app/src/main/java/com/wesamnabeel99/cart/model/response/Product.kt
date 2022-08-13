package com.wesamnabeel99.cart.model.response

data class Product(
    val category: Category?,
    val description: String?,
    val id: Int?,
    val images: List<String>?,
    val price: Double?,
    val title: String?,
)