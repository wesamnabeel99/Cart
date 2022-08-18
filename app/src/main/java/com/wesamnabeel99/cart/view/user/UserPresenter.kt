package com.wesamnabeel99.cart.view.user

import com.wesamnabeel99.cart.view.base.BasePresenter

class UserPresenter(private val view: IUserView) : BasePresenter() {

    fun getUsers() {
        cartRepository.createStreamOfStates(
            getResponseState = cartRepository::getUsers,
            onSuccess = view::onUserSuccess
        )
    }

}