package com.wesamnabeel99.cart.model.network.retrofit

import com.wesamnabeel99.cart.model.network.State
import com.wesamnabeel99.cart.model.network.client.Client
import com.wesamnabeel99.cart.utils.Constants
import okhttp3.HttpUrl


class Retrofit : ApiService {
    override fun <T> getProducts(responseType: Class<T>): State<T> {
        val httpUrl = HttpUrl.Builder()
            .scheme(Constants.SCHEME)
            .host(Constants.HOST)
            .addPathSegments(Constants.PRODUCTS_PATH_SEGMENT)
            .build()

        val okHttpClient = Client()
        return okHttpClient.requestData(httpUrl, responseType)

    }
}