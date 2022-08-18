package com.wesamnabeel99.cart.view.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavArgument
import androidx.navigation.fragment.navArgs
import com.wesamnabeel99.cart.databinding.FragmentProductsBinding
import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.product.ProductsResponse
import com.wesamnabeel99.cart.utils.Constants
import com.wesamnabeel99.cart.utils.logStates
import com.wesamnabeel99.cart.view.base.BaseFragment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ProductsFragment : BaseFragment<FragmentProductsBinding, ProductsPresenter>(), IProductsView,
    ProductInteractionListener {
    override val presenterType = ProductsPresenter(this)
    val arguments : ProductsFragmentArgs by navArgs()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentProductsBinding =
        FragmentProductsBinding::inflate
    private val listener = this

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.getProducts(arguments.categoryId)
    }


    override fun onProductsSuccess(products: Flow<State<ProductsResponse>>) {
        lifecycleScope.launch {
            products.collect { state ->
                state.logStates()
                if (state is State.Success) {
                    val adapter = ProductsAdapter(state.data, listener)
                    binding.recyclerView.adapter = adapter
                }
            }
        }
    }


    override fun onProductClick(id: Int) {

    }



}