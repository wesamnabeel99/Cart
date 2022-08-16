package com.wesamnabeel99.cart.utils

import android.util.Log
import com.wesamnabeel99.cart.model.network.state.State
import okhttp3.HttpUrl

fun HttpUrl.Builder.buildBaseUrl() = this.scheme(Constants.SCHEME)
    .host(Constants.HOST)

fun <T> State<T>.logStates() {
    when (this) {
        is State.Fail -> Log.i(this::class.java.simpleName, "failed: ${this.message}")
        State.Loading -> Log.i(this::class.java.simpleName, "loading...")
        is State.Success -> Log.i(this::class.java.simpleName, "success: ${this.data}")
    }
}