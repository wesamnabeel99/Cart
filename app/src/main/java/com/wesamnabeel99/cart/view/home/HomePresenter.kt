package com.wesamnabeel99.cart.view.home

import android.os.Build
import androidx.annotation.RequiresApi
import com.wesamnabeel99.cart.model.network.State
import com.wesamnabeel99.cart.model.response.CartResponse
import com.wesamnabeel99.cart.view.base.BasePresenter
import io.reactivex.rxjava3.core.Observable

class HomePresenter(view: IHomeView) : BasePresenter<IHomeView>(view) {


    @RequiresApi(Build.VERSION_CODES.O)
    fun getProducts() {
        val results = Observable.create<State<CartResponse>> {
            it.onNext(cartRepository.getProducts())
        }
        view.onProductsSuccess(results)
    }
}