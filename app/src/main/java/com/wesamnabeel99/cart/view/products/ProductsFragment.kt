package com.wesamnabeel99.cart.view.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.wesamnabeel99.cart.databinding.FragmentProductsBinding
import com.wesamnabeel99.cart.model.response.product.ProductsResponse
import com.wesamnabeel99.cart.utils.extensions.hide
import com.wesamnabeel99.cart.utils.extensions.navigateToFragment
import com.wesamnabeel99.cart.utils.extensions.show
import com.wesamnabeel99.cart.view.base.BaseFragment
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
        lifecycleScope.launch {
            presenter.getProducts(arguments.categoryId)
        }
    }


    override fun onLoading() {
        binding.apply {
            loadingState.show()
            errorState.hide()
            successState.hide()
        }
    }

    override fun onSuccess(data: ProductsResponse) {
        binding.apply {
            successState.show()
            errorState.hide()
            loadingState.hide()
            setAdapter(data)
        }
    }

    private fun setAdapter(data: ProductsResponse) {
        val adapter = ProductsAdapter(data, listener)
        binding.recyclerView.adapter = adapter
    }


    override fun onFail(message: String) {
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