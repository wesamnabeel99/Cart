package com.wesamnabeel99.cart.view.home

import com.wesamnabeel99.cart.view.base.BasePresenter

class HomePresenter(view: IHomeView) : BasePresenter<IHomeView>(view) {

    fun getCategory() {
        cartRepository.createStreamOfStates(
            getResponseState = cartRepository::getCategories,
            onSuccess = view::onCategorySuccess
        )
    }

    fun getUsers() {
        cartRepository.createStreamOfStates(
            getResponseState = cartRepository::getUsers,
            onSuccess = view::onUserSuccess
        )
    }

    fun getProducts() {
        cartRepository.createStreamOfStates(
            getResponseState = cartRepository::getProducts,
            onSuccess = view::onProductsSuccess
        )
    }


}