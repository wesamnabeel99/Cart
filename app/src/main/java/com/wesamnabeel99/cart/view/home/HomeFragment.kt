package com.wesamnabeel99.cart.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wesamnabeel99.cart.databinding.FragmentHomeBinding
import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.CategoryResponse
import com.wesamnabeel99.cart.model.response.ProductsResponse
import com.wesamnabeel99.cart.model.response.users.UserResponse
import com.wesamnabeel99.cart.utils.tempFunction
import com.wesamnabeel99.cart.view.base.BaseFragment
import io.reactivex.rxjava3.core.Observable

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

    override fun onCategorySuccess(categories: Observable<State<CategoryResponse>>) {
        categories.tempFunction()
    }

    override fun onUserSuccess(users: Observable<State<UserResponse>>) {
        users.tempFunction()
    }

    override fun onProductsSuccess(products: Observable<State<ProductsResponse>>) {
        products.tempFunction()
    }


}