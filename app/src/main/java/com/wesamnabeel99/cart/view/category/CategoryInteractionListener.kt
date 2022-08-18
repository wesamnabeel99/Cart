package com.wesamnabeel99.cart.view.category

import com.wesamnabeel99.cart.view.base.BaseInteractionListener

interface CategoryInteractionListener : BaseInteractionListener {
    fun onCategoryClick(categoryId: Int)
}