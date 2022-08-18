package com.wesamnabeel99.cart.utils.extensions

import android.view.View
import android.widget.ImageView
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.wesamnabeel99.cart.R

fun View.hide() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}


fun ImageView.loadImageUrl(url: String) {
    Glide.with(this.context)
        .load(url)
        .placeholder(R.drawable.ic_baseline_shopping_cart_24)
        .error(R.drawable.ic_baseline_error_24)
        .into(this)
}


fun View.navigateToFragment(action: NavDirections) {
    Navigation.findNavController(this).navigate(action)
}
