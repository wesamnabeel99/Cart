package com.wesamnabeel99.cart.view.base

interface IBaseView<T> {
    fun onSuccess(data: T)
    fun onFail(message: String)
    fun onLoading()
}