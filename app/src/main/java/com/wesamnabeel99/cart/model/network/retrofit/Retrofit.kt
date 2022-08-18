package com.wesamnabeel99.cart.model.network.retrofit

import com.wesamnabeel99.cart.model.network.client.Client
import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.category.CategoryResponse
import com.wesamnabeel99.cart.model.response.product.Product
import com.wesamnabeel99.cart.model.response.product.ProductsResponse
import com.wesamnabeel99.cart.model.response.users.UserResponse
import com.wesamnabeel99.cart.utils.Constants
import com.wesamnabeel99.cart.utils.extensions.buildBaseUrl
import okhttp3.HttpUrl


class Retrofit : ApiService {
    private val okHttpClient = Client()

    override fun requestProducts(id: Int): State<ProductsResponse> {
        val httpUrl = HttpUrl.Builder().buildBaseUrl()
            .addPathSegment(Constants.CATEGORY_PATH_SEGMENT)
            .addPathSegments("${id}/products")
            .build()

        return okHttpClient.requestData(httpUrl, ProductsResponse::class.java)
    }

    override fun requestProduct(productId: Int): State<Product> {
        val httpUrl = HttpUrl.Builder().buildBaseUrl()
            .addPathSegment(Constants.PRODUCTS_PATH_SEGMENT)
            .addPathSegments("$productId")
            .build()

        return okHttpClient.requestData(httpUrl, Product::class.java)
    }

    override fun requestCategories(): State<CategoryResponse> {
        val httpUrl = HttpUrl.Builder().buildBaseUrl()
            .addPathSegment(Constants.CATEGORY_PATH_SEGMENT)
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