package com.wesamnabeel99.cart.view.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.wesamnabeel99.cart.databinding.FragmentCategoryBinding
import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.category.CategoryResponse
import com.wesamnabeel99.cart.utils.extensions.hide
import com.wesamnabeel99.cart.utils.extensions.logStates
import com.wesamnabeel99.cart.utils.extensions.navigateToFragment
import com.wesamnabeel99.cart.utils.extensions.show
import com.wesamnabeel99.cart.view.base.BaseFragment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class CategoryFragment : BaseFragment<FragmentCategoryBinding, CategoryPresenter>(), ICategoryView,
    CategoryInteractionListener {
    override val presenterType = CategoryPresenter(this)
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCategoryBinding =
        FragmentCategoryBinding::inflate

    private val listener = this


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getCategory()
    }


    override fun onCategorySuccess(categories: Flow<State<CategoryResponse>>) {
        lifecycleScope.launch {
            categories.collect { state ->
                state.logStates()
                showResponseState(state)
            }
        }
    }

    private fun showResponseState(state: State<CategoryResponse>) {
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

    private fun showSuccessState(data: CategoryResponse) {
        val adapter = CategoryAdapter(data, listener)
        binding.apply {
            successState.show()
            loadingState.hide()
            errorState.hide()
            recyclerView.adapter = adapter
        }
    }

    private fun showFailState() {
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