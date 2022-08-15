package com.wesamnabeel99.cart.utils

import android.util.Log
import com.wesamnabeel99.cart.model.network.state.State
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.HttpUrl

fun HttpUrl.Builder.buildBaseUrl() = this.scheme(Constants.SCHEME)
    .host(Constants.HOST)

fun <T> Observable<State<T>>.tempFunction() {
    this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            {
                when (it) {
                    is State.Fail -> Log.i("TEST", "onSuccess, Fail State: ${it.message} ")
                    State.Loading -> Log.i("TEST", "loading..")
                    is State.Success -> Log.i("TEST", it.toString())
                }
            }, {
                Log.i("TEST", "onError, Fail State: ${it.message}")
            }
        )
}