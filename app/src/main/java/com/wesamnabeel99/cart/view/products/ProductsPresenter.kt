package com.wesamnabeel99.cart.view.products

import com.wesamnabeel99.cart.view.base.BasePresenter

class ProductsPresenter(private val view: IProductsView) : BasePresenter() {
    suspend fun getProducts(categoryId: Int) {
        cartRepository.createStreamOfStates(
            id = categoryId,
            getResponseState = cartRepository::getProductsOfCategory,
        ).collect { state ->
            handleState(
                state = state,
                onSuccess = view::onSuccess,
                onLoading = view::onLoading,
                onFail = view::onFail,
            )
        }


    }
}