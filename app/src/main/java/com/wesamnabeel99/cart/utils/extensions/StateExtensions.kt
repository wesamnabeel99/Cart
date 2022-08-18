package com.wesamnabeel99.cart.utils.extensions

import android.util.Log
import com.wesamnabeel99.cart.model.network.state.State

fun <T> State<T>.logStates() {
    when (this) {
        is State.Fail -> Log.i(this::class.java.simpleName, "failed: $message")
        State.Loading -> Log.i(this::class.java.simpleName, "loading...")
        is State.Success -> Log.i(this::class.java.simpleName, "success: $data")
    }
}
