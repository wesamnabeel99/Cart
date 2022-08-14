package com.wesamnabeel99.cart.model.repositories.cart

import com.wesamnabeel99.cart.model.network.State
import com.wesamnabeel99.cart.model.network.retrofit.Retrofit
import com.wesamnabeel99.cart.model.response.CategoryResponse
import com.wesamnabeel99.cart.model.response.ProductsResponse
import com.wesamnabeel99.cart.model.response.users.UserResponse

class CartRepository {

    private val retrofit = Retrofit()

    fun getProducts(): State<ProductsResponse> {
        return when (val result =
            retrofit.getProducts()) {
            is State.Fail -> State.Fail(result.errorMessage)
            State.Loading -> State.Loading
            is State.Success -> State.Success(result.data)
        }
    }

    fun getCategories(): State<CategoryResponse> {
        return when (val result =
            retrofit.getCategories()) {
            is State.Fail -> State.Fail(result.errorMessage)
            State.Loading -> State.Loading
            is State.Success -> State.Success(result.data)
        }
    }

    fun getUsers(): State<UserResponse> {
        return when (val result =
            retrofit.getUsers()) {
            is State.Fail -> State.Fail(result.errorMessage)
            State.Loading -> State.Loading
            is State.Success -> State.Success(result.data)
        }
    }
}