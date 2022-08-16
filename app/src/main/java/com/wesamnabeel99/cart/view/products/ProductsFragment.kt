package com.wesamnabeel99.cart.view.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.wesamnabeel99.cart.databinding.FragmentCategoryBinding
import com.wesamnabeel99.cart.databinding.FragmentProductsBinding
import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.ProductsResponse
import com.wesamnabeel99.cart.utils.logStates
import com.wesamnabeel99.cart.view.base.BaseFragment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ProductsFragment : BaseFragment<FragmentProductsBinding>(), IProductsView {
    private val presenter = ProductsPresenter(this)
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentProductsBinding =
        FragmentProductsBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getInt("KEY") ?: 3 // number 3 for test
        presenter.getProducts(id)
    }


    override fun onProductsSuccess(products: Flow<State<ProductsResponse>>) {
        lifecycleScope.launch {
            products.collect { state ->
                state.logStates()
            }
        }
    }


    companion object {
        fun createNewInstance(data: Int): ProductsFragment {
            return ProductsFragment().apply {
                arguments = Bundle().apply {
                    putInt("KEY", data)
                }
            }

        }
    }


}