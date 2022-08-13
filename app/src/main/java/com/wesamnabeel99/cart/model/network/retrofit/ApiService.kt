package com.wesamnabeel99.cart.model.network.retrofit

import com.wesamnabeel99.cart.model.network.State


interface ApiService {
    fun <T> getProducts(responseType: Class<T>) : State<T>
}