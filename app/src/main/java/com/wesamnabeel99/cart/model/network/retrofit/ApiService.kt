package com.wesamnabeel99.cart.model.network.retrofit

import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.category.CategoryResponse
import com.wesamnabeel99.cart.model.response.product.ProductsResponse
import com.wesamnabeel99.cart.model.response.users.UserResponse

interface ApiService {
    fun requestProducts(id: Int): State<ProductsResponse>
    fun requestCategories(): State<CategoryResponse>
    fun requestUsers(): State<UserResponse>
}