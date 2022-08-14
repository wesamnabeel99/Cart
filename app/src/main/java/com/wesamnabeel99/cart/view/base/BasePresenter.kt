package com.wesamnabeel99.cart.view.base

import com.wesamnabeel99.cart.model.network.State
import com.wesamnabeel99.cart.model.repositories.cart.CartRepository
import io.reactivex.rxjava3.core.Observable

abstract class BasePresenter<T>(protected val view: T) {
    protected val cartRepository = CartRepository()

    protected fun <T> getData(
        getFromRepository: () -> State<T>,
        onSuccess: (results: Observable<State<T>>) -> Unit
    ) {
        val results = Observable.create<State<T>> {
            it.onNext(State.Loading)
            it.onNext(getFromRepository())
        }
        onSuccess(results)
    }
}