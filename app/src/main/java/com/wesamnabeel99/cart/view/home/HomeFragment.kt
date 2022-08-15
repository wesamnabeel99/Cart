package com.wesamnabeel99.cart.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.wesamnabeel99.cart.databinding.FragmentHomeBinding
import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.CategoryResponse
import com.wesamnabeel99.cart.model.response.ProductsResponse
import com.wesamnabeel99.cart.model.response.users.UserResponse
import com.wesamnabeel99.cart.view.base.BaseFragment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment<FragmentHomeBinding>(), IHomeView {
    private val presenter = HomePresenter(this)
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getCategory()
        presenter.getUsers()
        presenter.getProducts()
    }

    override fun onCategorySuccess(categories: Flow<State<CategoryResponse>>) {
        lifecycleScope.launch {
            categories.collect {
                when (it) {
                    is State.Fail -> binding.categoryTextView.text = it.message
                    State.Loading -> binding.categoryTextView.text = "fetching..."
                    is State.Success -> binding.categoryTextView.text = it.data[0].name.toString()
                }
            }
        }
    }

    override fun onUserSuccess(users: Flow<State<UserResponse>>) {
        lifecycleScope.launch {
            users.collect {
                when (it) {
                    is State.Fail -> binding.userTextView.text = it.message
                    State.Loading -> binding.userTextView.text = "fetching..."
                    is State.Success -> binding.userTextView.text = it.data[0].name.toString()
                }
            }
        }
    }

    override fun onProductsSuccess(products: Flow<State<ProductsResponse>>) {
        lifecycleScope.launch {
            products.collect {
                when (it) {
                    is State.Fail -> binding.productTextView.text = it.message
                    State.Loading -> binding.productTextView.text = "fetching..."
                    is State.Success -> binding.productTextView.text = it.data[0].title.toString()
                }
            }
        }
    }


}