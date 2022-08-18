package com.wesamnabeel99.cart.view

import android.view.LayoutInflater
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.wesamnabeel99.cart.R
import com.wesamnabeel99.cart.databinding.ActivityMainBinding
import com.wesamnabeel99.cart.view.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding =
        ActivityMainBinding::inflate

    override fun onResume() {
        super.onResume()
        val navController = findNavController(R.id.fragment_container)
        binding.bottomNav.setupWithNavController(navController)
    }
}