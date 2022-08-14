package com.wesamnabeel99.cart.view.home

import com.wesamnabeel99.cart.model.network.State
import com.wesamnabeel99.cart.model.response.CategoryResponse
import com.wesamnabeel99.cart.model.response.users.UserResponse
import com.wesamnabeel99.cart.view.base.BasePresenter
import io.reactivex.rxjava3.core.Observable

class HomePresenter(view: IHomeView) : BasePresenter<IHomeView>(view) {

    fun getCategory() {
        val results = Observable.create<State<CategoryResponse>> {
            it.onNext(State.Loading)
            it.onNext(cartRepository.getCategories())
        }
        view.onCategorySuccess(results)
    }

    fun getUsers() {
        val results = Observable.create<State<UserResponse>> {
            it.onNext(State.Loading)
            it.onNext(cartRepository.getUsers())
        }
        view.onUserSuccess(results)
    }
}