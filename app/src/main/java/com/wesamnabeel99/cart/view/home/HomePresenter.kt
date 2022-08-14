package com.wesamnabeel99.cart.view.home

import com.wesamnabeel99.cart.view.base.BasePresenter

class HomePresenter(view: IHomeView) : BasePresenter<IHomeView>(view) {

    fun getCategory() {
        getData(
            getFromRepository = cartRepository::getCategories,
            onSuccess = view::onCategorySuccess
        )
    }

    fun getUsers() {
        getData(
            getFromRepository = cartRepository::getUsers,
            onSuccess = view::onUserSuccess
        )
    }

    fun getProducts() {
        getData(
            getFromRepository = cartRepository::getProducts,
            onSuccess = view::onProductsSuccess
        )
    }


}