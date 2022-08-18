package com.wesamnabeel99.cart.model.response.product

import com.wesamnabeel99.cart.model.response.category.Category

data class Product(
    val category: Category?,
    val description: String?,
    val id: Int?,
    val images: List<String>?,
    val price: Double?,
    val title: String?,
)