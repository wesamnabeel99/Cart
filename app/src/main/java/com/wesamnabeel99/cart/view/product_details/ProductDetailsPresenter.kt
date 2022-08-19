package com.wesamnabeel99.cart.view.product_details

import com.wesamnabeel99.cart.view.base.BasePresenter

class ProductDetailsPresenter(private val view: IProductDetailsView) : BasePresenter() {
    suspend fun getProductDetails(categoryId: Int) {
        cartRepository.createStreamOfStates(
            id = categoryId,
            getResponseState = cartRepository::getProductDetails,
        ).collect { state ->
            handleState(
                state = state,
                onLoading = view::onLoading,
                onSuccess = view::onSuccess,
                onFail = view::onFail
            )
        }
    }
}