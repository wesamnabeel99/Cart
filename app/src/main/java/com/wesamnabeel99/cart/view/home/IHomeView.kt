package com.wesamnabeel99.cart.view.home

import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.CategoryResponse
import com.wesamnabeel99.cart.model.response.ProductsResponse
import com.wesamnabeel99.cart.model.response.users.UserResponse
import io.reactivex.rxjava3.core.Observable

interface IHomeView {
    fun onCategorySuccess(categories: Observable<State<CategoryResponse>>)
    fun onUserSuccess(users: Observable<State<UserResponse>>)
    fun onProductsSuccess(products: Observable<State<ProductsResponse>>)
}