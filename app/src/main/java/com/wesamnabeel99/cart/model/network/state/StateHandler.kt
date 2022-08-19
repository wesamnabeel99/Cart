package com.wesamnabeel99.cart.model.network.state

object StateHandler {
    fun <T> handleState(
        state: State<T>,
        showLoadingState: () -> Unit,
        showSuccessState: (response: T) -> Unit,
        showErrorState: (message: String) -> Unit,
    ) {
        when (state) {
            is State.Fail -> showErrorState(state.message)
            State.Loading -> showLoadingState()
            is State.Success -> showSuccessState(state.data)
        }
    }
}