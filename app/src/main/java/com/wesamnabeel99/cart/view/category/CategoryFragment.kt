package com.wesamnabeel99.cart.view.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.wesamnabeel99.cart.databinding.FragmentCategoryBinding
import com.wesamnabeel99.cart.model.response.category.CategoryResponse
import com.wesamnabeel99.cart.utils.extensions.hide
import com.wesamnabeel99.cart.utils.extensions.navigateToFragment
import com.wesamnabeel99.cart.utils.extensions.show
import com.wesamnabeel99.cart.view.base.BaseFragment
import kotlinx.coroutines.launch

class CategoryFragment : BaseFragment<FragmentCategoryBinding, CategoryPresenter>(), ICategoryView,
    CategoryInteractionListener {
    override val presenterType = CategoryPresenter(this)
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCategoryBinding =
        FragmentCategoryBinding::inflate

    private val listener = this


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            presenter.getCategory()
        }
    }


    override fun onLoading() {
        binding.apply {
            loadingState.show()
            errorState.hide()
            successState.hide()
        }
    }

    override fun onSuccess(data: CategoryResponse) {
        setAdapter(data)
        binding.apply {
            successState.show()
            loadingState.hide()
            errorState.hide()
        }
    }

    private fun setAdapter(data: CategoryResponse) {
        val adapter = CategoryAdapter(data, listener)
        binding.recyclerView.adapter = adapter
    }

    override fun onFail(message: String) {
        binding.apply {
            errorState.show()
            successState.hide()
            loadingState.hide()
        }
    }


    override fun onCategoryClick(categoryId: Int) {
        val action = CategoryFragmentDirections.actionCategoryFragmentToProductsFragment(categoryId)
        binding.root.navigateToFragment(action)
    }


}