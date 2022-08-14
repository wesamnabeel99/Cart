package com.wesamnabeel99.cart.view.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wesamnabeel99.cart.databinding.FragmentHomeBinding
import com.wesamnabeel99.cart.model.network.State
import com.wesamnabeel99.cart.model.response.CategoryResponse
import com.wesamnabeel99.cart.model.response.users.UserResponse
import com.wesamnabeel99.cart.view.base.BaseFragment
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeFragment : BaseFragment<FragmentHomeBinding>(), IHomeView {
    private val presenter = HomePresenter(this)
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getCategory()
        presenter.getUsers()
    }

    override fun onCategorySuccess(categories: Observable<State<CategoryResponse>>) {
        categories.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    when (it) {
                        is State.Fail -> Log.i("CATEGORY", it.errorMessage)
                        State.Loading -> Log.i("CATEGORY", "loading..")
                        is State.Success -> it.data.forEach {
                            Log.i("CATEGORY", it.toString())
                        }
                    }
                }, {
                    Log.i("HOME_FRAGMENT", "error ${it.message}")
                }
            )
    }

    override fun onUserSuccess(users: Observable<State<UserResponse>>) {
        users.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    when (it) {
                        is State.Fail -> Log.i("USERS", it.errorMessage)
                        State.Loading -> Log.i("USERS", "loading..")
                        is State.Success -> it.data.forEach {
                            Log.i("USERS", it.toString())
                        }
                    }
                }, {
                    Log.i("HOME_FRAGMENT", "error ${it.message}")
                }
            )
    }


}