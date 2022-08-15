package com.wesamnabeel99.cart.model.repositories.cart

import android.util.Log
import com.wesamnabeel99.cart.model.network.retrofit.ApiService
import com.wesamnabeel99.cart.model.network.retrofit.Retrofit
import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.network.state.StreamCreator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

class CartRepository {

    lateinit var retrofit: ApiService
    private val streamCreator = StreamCreator()

    fun getProducts() = retrofit.requestProducts()

    fun getCategories() = retrofit.requestCategories()

    fun getUsers() = retrofit.requestUsers()

    fun <T> createStreamOfStates(
        getResponseState: () -> State<T>,
        onSuccess: (data: Flow<State<T>>) -> Unit
    ) {
        retrofit = Retrofit()
        val flowOfStates =
            streamCreator.createFlowOfStates(getResponseState).flowOn(Dispatchers.IO).catch {
                Log.i("FLOW", "${it.message}")
            }
        onSuccess(flowOfStates)
    }


}