package com.wesamnabeel99.cart.model.network.state

import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class StreamCreator {

    fun <T> createObservableOfStates(
        getResponseState: () -> State<T>,
    ): Observable<State<T>> {
        return Observable.create {
            it.onNext(State.Loading)
            val state = getResponseState()
            it.onNext(state)
        }
    }

    fun <T> createFlowOfStates(
        getResponseState: () -> State<T>,
    ): Flow<State<T>> {
        return flow {
            emit(State.Loading)
            emit(getResponseState())
        }
    }


}