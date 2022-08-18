package com.wesamnabeel99.cart.view.product_details

import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.product.Product
import com.wesamnabeel99.cart.model.response.product.ProductsResponse
import kotlinx.coroutines.flow.Flow

interface IProductDetailsView {
    fun onProductSuccess(product: Flow<State<Product>>)
}