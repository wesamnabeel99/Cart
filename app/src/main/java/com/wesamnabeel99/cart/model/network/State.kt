package com.wesamnabeel99.cart.model.network

sealed class State<out T> {
    object Loading : State<Nothing>()
    data class Fail(val errorMessage: String) : State<Nothing>()
    data class Success<T>(val data: T) : State<T>()
}
