package com.wesamnabeel99.cart.view.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.wesamnabeel99.cart.databinding.FragmentCategoryBinding
import com.wesamnabeel99.cart.databinding.FragmentHomeBinding
import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.ProductsResponse
import com.wesamnabeel99.cart.view.base.BaseFragment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class CategoryFragment : BaseFragment<FragmentCategoryBinding>(), ICategoryView {
    private val presenter = CategoryPresenter(this)
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCategoryBinding =
        FragmentCategoryBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getProducts()
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


    companion object {

        fun createNewInstance(data:String): CategoryFragment {
            return CategoryFragment().apply {
                arguments=Bundle().apply {
                    putString("KEY",data)
                }
            }

        }
    }


}