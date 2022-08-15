package com.wesamnabeel99.cart.view.base

import com.wesamnabeel99.cart.model.repositories.cart.CartRepository

abstract class BasePresenter {
    protected val cartRepository = CartRepository()
}