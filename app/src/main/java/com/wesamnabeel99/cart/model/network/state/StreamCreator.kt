package com.wesamnabeel99.cart.model.network.state

import io.reactivex.rxjava3.core.Observable

class StreamCreator  {

    fun <T> createObservableOfStates(
        getResponseState: () -> State<T>,
        onSuccess: (results: Observable<State<T>>) -> Unit
    ) {
        val dataObservable = Observable.create<State<T>> {
            it.onNext(State.Loading)
            val state = getResponseState()
            it.onNext(state)
        }
        onSuccess(dataObservable)
    }

    fun <T> createFlowOfStates(
        getResponseState: () -> State<T>,
        onSuccess: (results: Observable<State<T>>) -> Unit
    ) {
        TODO("use flow instead of observable")
    }



}