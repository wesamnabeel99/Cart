package com.wesamnabeel99.cart.view.home

import com.wesamnabeel99.cart.model.network.State
import com.wesamnabeel99.cart.model.response.CartResponse
import io.reactivex.rxjava3.core.Observable

interface IHomeView {
    fun onProductsSuccess(products: Observable<State<CartResponse>>)
}