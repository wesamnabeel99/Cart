package com.wesamnabeel99.cart.model.network.retrofit

import com.wesamnabeel99.cart.model.network.State
import com.wesamnabeel99.cart.model.response.CategoryResponse
import com.wesamnabeel99.cart.model.response.ProductsResponse
import com.wesamnabeel99.cart.model.response.users.UserResponse


interface ApiService {
    fun getProducts(): State<ProductsResponse>
    fun getCategories(): State<CategoryResponse>
    fun getUsers(): State<UserResponse>
}