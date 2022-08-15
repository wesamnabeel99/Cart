package com.wesamnabeel99.cart.model.network.retrofit

import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.CategoryResponse
import com.wesamnabeel99.cart.model.response.ProductsResponse
import com.wesamnabeel99.cart.model.response.users.UserResponse


interface ApiService {
    fun requestProducts(): State<ProductsResponse>
    fun requestCategories(): State<CategoryResponse>
    fun requestUsers(): State<UserResponse>
}