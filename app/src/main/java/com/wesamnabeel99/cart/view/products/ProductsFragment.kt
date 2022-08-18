package com.wesamnabeel99.cart.view.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.wesamnabeel99.cart.databinding.FragmentProductsBinding
import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.product.ProductsResponse
import com.wesamnabeel99.cart.utils.hide
import com.wesamnabeel99.cart.utils.logStates
import com.wesamnabeel99.cart.utils.navigateToFragment
import com.wesamnabeel99.cart.utils.show
import com.wesamnabeel99.cart.view.base.BaseFragment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ProductsFragment : BaseFragment<FragmentProductsBinding, ProductsPresenter>(), IProductsView,
    ProductInteractionListener {
    override val presenterType = ProductsPresenter(this)
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentProductsBinding =
        FragmentProductsBinding::inflate

    private val arguments: ProductsFragmentArgs by navArgs()
    private val listener = this


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.getProducts(arguments.categoryId)
    }


    override fun onProductsSuccess(products: Flow<State<ProductsResponse>>) {
        lifecycleScope.launch {
            products.collect { state ->
                state.logStates()
                showResponseState(state)
            }
        }
    }

    private fun showResponseState(state: State<ProductsResponse>) {
        when (state) {
            State.Loading -> showLoadingState()
            is State.Success -> showSuccessState(state.data)
            is State.Fail -> showFailState()
        }
    }


    private fun showLoadingState() {
        binding.apply {
            loadingState.show()
            errorState.hide()
            successState.hide()
        }

    }

    private fun showSuccessState(products: ProductsResponse) {
        binding.apply {
            successState.show()
            errorState.hide()
            loadingState.hide()
            val adapter = ProductsAdapter(products, listener)
            binding.recyclerView.adapter = adapter
        }
    }

    private fun showFailState() {
        binding.apply {
            errorState.show()
            loadingState.hide()
            successState.hide()
        }
    }


    override fun onProductClick(id: Int) {
        val action = ProductsFragmentDirections.actionProductsFragmentToProductDetailsFragment(id)
        binding.root.navigateToFragment(action)
    }


}