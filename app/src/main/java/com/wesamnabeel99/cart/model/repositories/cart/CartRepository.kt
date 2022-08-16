package com.wesamnabeel99.cart.model.repositories.cart

import com.wesamnabeel99.cart.model.network.retrofit.Retrofit
import com.wesamnabeel99.cart.model.network.state.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CartRepository : ICartRepository {

    private val retrofit = Retrofit()

    override fun getProducts(id: Int) = retrofit.requestProducts(id)

    override fun getCategories() = retrofit.requestCategories()

    override fun getUsers() = retrofit.requestUsers()

    fun <T> createStreamOfStates(
        getResponseState: () -> State<T>,
        onSuccess: (data: Flow<State<T>>) -> Unit
    ) {

        val flowOfStates = flow {
            emit(State.Loading)
            emit(getResponseState())
        }.flowOn(Dispatchers.IO).catch {
            emit(State.Fail(it.message.toString()))
        }

        onSuccess(flowOfStates)
    }

    // function overloading because in some cases we need to pass the id to complete the request
    fun <T> createStreamOfStates(
        id: Int,
        getResponseState: (id: Int) -> State<T>,
        onSuccess: (data: Flow<State<T>>) -> Unit
    ) {

        val flowOfStates = flow {
            emit(State.Loading)
            emit(getResponseState(id))
        }.flowOn(Dispatchers.IO).catch {
            emit(State.Fail(it.message.toString()))
        }

        onSuccess(flowOfStates)
    }
}