package com.wesamnabeel99.cart.view.base

import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.repositories.cart.CartRepository
import com.wesamnabeel99.cart.utils.extensions.logStates

abstract class BasePresenter {
    protected val cartRepository = CartRepository()

    protected fun <T> handleState(
        state : State<T>,
        onLoading: () -> Unit,
        onSuccess: (response: T) -> Unit,
        onFail: (message: String) -> Unit,
    ) {
        state.logStates()
        when (state) {
            is State.Fail -> onFail(state.message)
            State.Loading -> onLoading()
            is State.Success -> onSuccess(state.data)
        }
    }
}