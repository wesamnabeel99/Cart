package com.wesamnabeel99.cart.view.product_details

import com.wesamnabeel99.cart.view.base.BasePresenter

class ProductDetailsPresenter(private val view: IProductDetailsView) : BasePresenter() {

    fun getProductDetails(categoryId: Int) {
        cartRepository.createStreamOfStates(
            id = categoryId,
            getResponseState = cartRepository::getProductDetails,
            onSuccess = view::onProductsDetailsSuccess
        )
    }


}