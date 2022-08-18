package com.wesamnabeel99.cart.view.products

import com.wesamnabeel99.cart.view.base.BaseInteractionListener

interface ProductInteractionListener : BaseInteractionListener {
    fun onProductClick(id: Int)
}