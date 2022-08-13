package com.wesamnabeel99.cart.view.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wesamnabeel99.cart.databinding.FragmentHomeBinding
import com.wesamnabeel99.cart.model.network.State
import com.wesamnabeel99.cart.model.response.CartResponse
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
        presenter.getProducts()
    }


    override fun onProductsSuccess(products: Observable<State<CartResponse>>) {
        products.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Log.i("HEY", "HEY! I'm here")
                    when (it) {
                        is State.Fail -> binding.textView.text = it.errorMessage
                        State.Loading -> binding.textView.text = "loading..."
                        is State.Success -> binding.textView.text = it.data.toString()
                    }
                }, {
                    Log.i("HOME_FRAGMENT", "error ${it.message}")
                }
            )

    }
}