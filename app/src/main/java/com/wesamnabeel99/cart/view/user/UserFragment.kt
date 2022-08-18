package com.wesamnabeel99.cart.view.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.wesamnabeel99.cart.databinding.FragmentUserBinding
import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.users.UserResponse
import com.wesamnabeel99.cart.utils.*
import com.wesamnabeel99.cart.utils.extensions.hide
import com.wesamnabeel99.cart.utils.extensions.loadImageUrl
import com.wesamnabeel99.cart.utils.extensions.logStates
import com.wesamnabeel99.cart.utils.extensions.show
import com.wesamnabeel99.cart.view.base.BaseFragment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class UserFragment :
    BaseFragment<FragmentUserBinding, UserPresenter>(),
    IUserView {
    override val presenterType = UserPresenter(this)
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentUserBinding =
        FragmentUserBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getUsers()
    }

    override fun onUserSuccess(users: Flow<State<UserResponse>>) {
        lifecycleScope.launch {
            users.collect { state ->
                state.logStates()
                showResponseState(state)
            }
        }
    }

    private fun showResponseState(state: State<UserResponse>) {
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

    private fun showSuccessState(userResponse: UserResponse) {
        val user = userResponse[Constants.CURRENT_USER]
        binding.apply {
            successState.show()
            errorState.hide()
            loadingState.hide()
            userImage.loadImageUrl(user.avatar.toString())
            userRole.text = user.role
            userName.text = user.name
        }
    }

    private fun showFailState() {
        binding.apply {
            errorState.show()
            loadingState.hide()
            successState.hide()
        }
    }

}