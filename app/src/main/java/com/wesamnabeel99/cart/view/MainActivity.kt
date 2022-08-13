package com.wesamnabeel99.cart.view

import android.view.LayoutInflater
import com.wesamnabeel99.cart.databinding.ActivityMainBinding
import com.wesamnabeel99.cart.view.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding =
        ActivityMainBinding::inflate
}