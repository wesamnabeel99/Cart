package com.wesamnabeel99.cart.view.home

import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.CategoryResponse
import com.wesamnabeel99.cart.model.response.ProductsResponse
import com.wesamnabeel99.cart.model.response.users.UserResponse
import kotlinx.coroutines.flow.Flow

interface IHomeView {
    fun onCategorySuccess(categories: Flow<State<CategoryResponse>>)
    fun onUserSuccess(users: Flow<State<UserResponse>>)
    fun onProductsSuccess(products: Flow<State<ProductsResponse>>)
}