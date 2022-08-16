package com.wesamnabeel99.cart.model.repositories.cart

import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.CategoryResponse
import com.wesamnabeel99.cart.model.response.ProductsResponse
import com.wesamnabeel99.cart.model.response.users.UserResponse

interface ICartRepository {

    fun getProducts(id: Int): State<ProductsResponse>

    fun getCategories() : State<CategoryResponse>

    fun getUsers() : State<UserResponse>

}