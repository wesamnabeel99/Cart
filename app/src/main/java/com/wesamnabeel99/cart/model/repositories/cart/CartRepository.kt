package com.wesamnabeel99.cart.model.repositories.cart

import android.util.Log
import com.wesamnabeel99.cart.model.network.retrofit.Retrofit
import com.wesamnabeel99.cart.model.network.State
import com.wesamnabeel99.cart.model.response.CartResponse

class CartRepository {

    private val retrofit = Retrofit()

    fun getProducts(): State<CartResponse> {
        val result = retrofit.getProducts(responseType = CartResponse::class.java)
        Log.i("HEY", "hey, i'll return now")
        return when (result) {
            is State.Fail -> State.Fail(result.errorMessage)
            State.Loading -> State.Loading
            is State.Success -> State.Success(result.data)
        }
    }


}