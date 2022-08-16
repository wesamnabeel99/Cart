package com.wesamnabeel99.cart.view.category

import com.wesamnabeel99.cart.view.base.BasePresenter

class CategoryPresenter(private val view: ICategoryView) : BasePresenter() {

    fun getProducts(id: Int) {
        cartRepository.createStreamOfStates(
            id = id,
            responseState = cartRepository::getProducts,
            onSuccess = view::onProductsSuccess
        )
    }


}