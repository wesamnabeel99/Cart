package com.wesamnabeel99.cart.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.wesamnabeel99.cart.databinding.FragmentHomeBinding
import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.CategoryResponse
import com.wesamnabeel99.cart.model.response.users.UserResponse
import com.wesamnabeel99.cart.utils.logStates
import com.wesamnabeel99.cart.view.base.BaseFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class HomeFragment : BaseFragment<FragmentHomeBinding>(), IHomeView {
    private val presenter = HomePresenter(this)
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch(Dispatchers.IO) {
            presenter.getCategory()
            presenter.getUsers()
        }

    }

    override fun onCategorySuccess(categories: Flow<State<CategoryResponse>>) {
        lifecycleScope.launch {
            categories.collect { state ->
                state.logStates()
            }
        }
    }

    override fun onUserSuccess(users: Flow<State<UserResponse>>) {
        lifecycleScope.launch {
            users.collect { state ->
                state.logStates()
            }
        }
    }


}