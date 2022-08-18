package com.wesamnabeel99.cart.view.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.wesamnabeel99.cart.databinding.FragmentCategoryBinding
import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.category.CategoryResponse
import com.wesamnabeel99.cart.model.response.users.UserResponse
import com.wesamnabeel99.cart.utils.logStates
import com.wesamnabeel99.cart.utils.navigateToFragment
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
        presenter.getUsers()
    }

    override fun onCategorySuccess(categories: Flow<State<CategoryResponse>>) {
        lifecycleScope.launch {
            categories.collect { state ->
                state.logStates()
                if (state is State.Success) {
                    val adapter = CategoryAdapter(state.data, listener)
                    binding.recyclerView.adapter = adapter
                }
            }
        }
    }

    override fun onUserSuccess(users: Flow<State<UserResponse>>) {
        lifecycleScope.launch {
            users.collect { state ->
                state.logStates()
            }
        }
    }

    override fun onCategoryClick(categoryId: Int) {
        binding.root.navigateToFragment(
            CategoryFragmentDirections.actionCategoryFragmentToProductsFragment(
                categoryId
            )
        )
    }


}