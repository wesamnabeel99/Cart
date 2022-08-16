package com.wesamnabeel99.cart.view.home

import com.wesamnabeel99.cart.view.base.BasePresenter

class HomePresenter(private val view: IHomeView) : BasePresenter() {

    fun getCategory() {
        cartRepository.createStreamOfStates(
            responseState = cartRepository::getCategories,
            onSuccess = view::onCategorySuccess
        )
    }

    fun getUsers() {
        cartRepository.createStreamOfStates(
            responseState = cartRepository::getUsers,
            onSuccess = view::onUserSuccess
        )
    }

}