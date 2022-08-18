package com.wesamnabeel99.cart.view.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import com.wesamnabeel99.cart.databinding.FragmentCartBinding
import com.wesamnabeel99.cart.view.base.BaseFragment

class CartFragment :
    BaseFragment<FragmentCartBinding, CartPresenter>(),
    ICartView {
    override val presenterType = CartPresenter(this)
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCartBinding =
        FragmentCartBinding::inflate

}