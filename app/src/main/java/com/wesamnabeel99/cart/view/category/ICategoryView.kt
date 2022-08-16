package com.wesamnabeel99.cart.view.category

import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.CategoryResponse
import com.wesamnabeel99.cart.model.response.ProductsResponse
import com.wesamnabeel99.cart.model.response.users.UserResponse
import kotlinx.coroutines.flow.Flow

interface ICategoryView {
    fun onProductsSuccess(products: Flow<State<ProductsResponse>>)
}