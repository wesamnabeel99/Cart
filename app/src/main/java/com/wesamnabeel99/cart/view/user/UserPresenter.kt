package com.wesamnabeel99.cart.view.user

import com.wesamnabeel99.cart.view.base.BasePresenter

class UserPresenter(private val view: IUserView) : BasePresenter() {
    suspend fun getUsers() {
        cartRepository.createStreamOfStates(
            getResponseState = cartRepository::getUsers,
        ).collect { state ->
            handleState(
                state = state,
                onLoading = view::onLoading,
                onSuccess = view::onSuccess,
                onFail = view::onFail,
            )
        }
    }
}