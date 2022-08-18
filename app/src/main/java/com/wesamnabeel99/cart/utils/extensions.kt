package com.wesamnabeel99.cart.utils

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.wesamnabeel99.cart.model.network.state.State
import okhttp3.HttpUrl

fun HttpUrl.Builder.buildBaseUrl() = this.scheme(Constants.SCHEME)
    .host(Constants.HOST).addPathSegments(Constants.API_PATH_SEGMENT)

fun <T> State<T>.logStates() {
    when (this) {
        is State.Fail -> Log.i(this::class.java.simpleName, "failed: $message")
        State.Loading -> Log.i(this::class.java.simpleName, "loading...")
        is State.Success -> Log.i(this::class.java.simpleName, "success: $data")
    }
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}



fun View.navigateToFragment(action: NavDirections) {
    Navigation.findNavController(this).navigate(action)
}

fun ImageView.loadImageUrl(url: String) {
    Glide.with(this.context).load(url).into(this)
}