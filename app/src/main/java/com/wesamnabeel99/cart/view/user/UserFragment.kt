package com.wesamnabeel99.cart.view.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.wesamnabeel99.cart.databinding.FragmentUserBinding
import com.wesamnabeel99.cart.model.response.users.UserResponse
import com.wesamnabeel99.cart.utils.Constants
import com.wesamnabeel99.cart.utils.extensions.hide
import com.wesamnabeel99.cart.utils.extensions.loadImageUrl
import com.wesamnabeel99.cart.utils.extensions.show
import com.wesamnabeel99.cart.view.base.BaseFragment
import kotlinx.coroutines.launch

class UserFragment :
    BaseFragment<FragmentUserBinding, UserPresenter>(),
    IUserView {
    override val presenterType = UserPresenter(this)
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentUserBinding =
        FragmentUserBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            presenter.getUsers()
        }
    }


    override fun onLoading() {
        binding.apply {
            loadingState.show()
            errorState.hide()
            successState.hide()
        }
    }

    override fun onSuccess(data: UserResponse) {
        val user = data[Constants.CURRENT_USER]
        binding.apply {
            successState.show()
            errorState.hide()
            loadingState.hide()
            userImage.loadImageUrl(user.avatar.toString())
            userRole.text = user.role
            userName.text = user.name
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