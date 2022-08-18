package com.wesamnabeel99.cart.view.category

import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.category.CategoryResponse
import com.wesamnabeel99.cart.model.response.users.UserResponse
import kotlinx.coroutines.flow.Flow

interface ICategoryView {
    fun onCategorySuccess(categories: Flow<State<CategoryResponse>>)
    fun onUserSuccess(users: Flow<State<UserResponse>>)
}