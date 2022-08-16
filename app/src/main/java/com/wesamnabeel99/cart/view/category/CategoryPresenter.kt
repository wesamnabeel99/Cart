package com.wesamnabeel99.cart.view.category

import com.wesamnabeel99.cart.view.base.BasePresenter

class CategoryPresenter(private val view: ICategoryView) : BasePresenter() {

    fun getProducts() {
        cartRepository.createStreamOfStates(
            getResponseState = cartRepository::getProducts,
            onSuccess = view::onProductsSuccess
        )
    }


}