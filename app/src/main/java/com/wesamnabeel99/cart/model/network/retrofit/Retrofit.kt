package com.wesamnabeel99.cart.model.network.retrofit

import com.wesamnabeel99.cart.model.network.client.Client
import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.CategoryResponse
import com.wesamnabeel99.cart.model.response.ProductsResponse
import com.wesamnabeel99.cart.model.response.users.UserResponse
import com.wesamnabeel99.cart.utils.Constants
import com.wesamnabeel99.cart.utils.buildBaseUrl
import okhttp3.HttpUrl


class Retrofit : ApiService {
    private val okHttpClient = Client()

    override fun requestProducts(): State<ProductsResponse> {
        val httpUrl = HttpUrl.Builder().buildBaseUrl()
            .addPathSegments(Constants.PRODUCTS_PATH_SEGMENT)
            .build()

        return okHttpClient.requestData(httpUrl, ProductsResponse::class.java)
    }

    override fun requestCategories(): State<CategoryResponse> {
        val httpUrl = HttpUrl.Builder().buildBaseUrl()
            .addPathSegments(Constants.CATEGORY_PATH_SEGMENT)
            .build()

        return okHttpClient.requestData(httpUrl, CategoryResponse::class.java)
    }

    override fun requestUsers(): State<UserResponse> {
        val httpUrl = HttpUrl.Builder().buildBaseUrl()
            .addPathSegments(Constants.USERS_PATH_SEGMENT)
            .build()

        return okHttpClient.requestData(httpUrl, UserResponse::class.java)
    }
}