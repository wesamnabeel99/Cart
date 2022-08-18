package com.wesamnabeel99.cart.view.product_details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.wesamnabeel99.cart.databinding.FragmentProductDetailsBinding
import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.product.Product
import com.wesamnabeel99.cart.utils.logStates
import com.wesamnabeel99.cart.view.base.BaseFragment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ProductDetailsFragment : BaseFragment<FragmentProductDetailsBinding, ProductDetailsPresenter>(),
    IProductDetailsView {
    override val presenterType = ProductDetailsPresenter(this)
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentProductDetailsBinding =
        FragmentProductDetailsBinding::inflate

    private val arguments: ProductDetailsFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("DETAILS",arguments.productId.toString())
        presenter.getProductDetails(arguments.productId)
    }


    override fun onProductSuccess(product: Flow<State<Product>>) {
        lifecycleScope.launch {
            product.collect { state ->
                state.logStates()
            }
        }
    }

}