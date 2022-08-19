package com.wesamnabeel99.cart.view.category

import com.wesamnabeel99.cart.view.base.BasePresenter

class CategoryPresenter(private val view: ICategoryView) : BasePresenter() {
    suspend fun getCategory() {
        cartRepository.createStreamOfStates(
            getResponseState = cartRepository::getCategories,
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