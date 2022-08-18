package com.wesamnabeel99.cart.view.products

import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.product.ProductsResponse
import kotlinx.coroutines.flow.Flow

interface IProductsView {
    fun onProductsSuccess(products: Flow<State<ProductsResponse>>)
}