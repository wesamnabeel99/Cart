package com.wesamnabeel99.cart.view.user

import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.product.Product
import com.wesamnabeel99.cart.model.response.product.ProductsResponse
import com.wesamnabeel99.cart.model.response.users.UserResponse
import kotlinx.coroutines.flow.Flow

interface IUserView {
    fun onUserSuccess(users: Flow<State<UserResponse>>)
}