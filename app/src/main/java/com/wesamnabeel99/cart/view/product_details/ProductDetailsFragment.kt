package com.wesamnabeel99.cart.view.product_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.wesamnabeel99.cart.databinding.FragmentProductDetailsBinding
import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.product.Product
import com.wesamnabeel99.cart.utils.extensions.hide
import com.wesamnabeel99.cart.utils.extensions.loadImageUrl
import com.wesamnabeel99.cart.utils.extensions.logStates
import com.wesamnabeel99.cart.utils.extensions.show
import com.wesamnabeel99.cart.view.base.BaseFragment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ProductDetailsFragment :
    BaseFragment<FragmentProductDetailsBinding, ProductDetailsPresenter>(),
    IProductDetailsView {
    override val presenterType = ProductDetailsPresenter(this)
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentProductDetailsBinding =
        FragmentProductDetailsBinding::inflate

    private val arguments: ProductDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            presenter.getProductDetails(arguments.productId)
        }
    }


    override fun onLoading() {
        binding.apply {
            loadingState.show()
            errorState.hide()
            successState.hide()
        }
    }

    override fun onSuccess(product: Product) {
        binding.apply {
            successState.show()
            errorState.hide()
            loadingState.hide()
            productName.text = product.title
            productDescription.text = product.description
            productImage.loadImageUrl(product.images?.get(0) ?: "")
            productPrice.text = product.price.toString() + " $"

            button.setOnClickListener {
                Toast.makeText(
                    this@ProductDetailsFragment.context,
                    "${product.title} added to the cart",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }

    override fun onFail(message: String) {
        binding.apply {
            errorState.show()
            loadingState.hide()
            successState.hide()
        }
    }

}