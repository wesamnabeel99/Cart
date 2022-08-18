package com.wesamnabeel99.cart.view.products

import com.wesamnabeel99.cart.view.base.BasePresenter

class ProductsPresenter(private val view: IProductsView) : BasePresenter() {

    fun getProducts(categoryId: Int) {
        cartRepository.createStreamOfStates(
            id = categoryId,
            getResponseState = cartRepository::getProductsOfCategory,
            onSuccess = view::onProductsSuccess
        )
    }


}