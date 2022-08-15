package com.wesamnabeel99.cart.model.network.state

sealed class State<out T> {
    object Loading : State<Nothing>()
    data class Fail(val message: String) : State<Nothing>()
    data class Success<T>(val data: T) : State<T>()
}
