package com.wesamnabeel99.cart.model.repositories.cart

import com.wesamnabeel99.cart.model.network.retrofit.ApiService
import com.wesamnabeel99.cart.model.network.retrofit.Retrofit
import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.network.state.StreamCreator
import io.reactivex.rxjava3.core.Observable

class CartRepository {

    lateinit var retrofit: ApiService
    private val streamCreator = StreamCreator()

    fun getProducts() = retrofit.requestProducts()

    fun getCategories() = retrofit.requestCategories()

    fun getUsers() = retrofit.requestUsers()

    fun <T> createStreamOfStates(
        getResponseState: () -> State<T>,
        onSuccess: (data: Observable<State<T>>) -> Unit
    ) {
        retrofit = Retrofit()
        streamCreator.createObservableOfStates(getResponseState, onSuccess)
    }


}