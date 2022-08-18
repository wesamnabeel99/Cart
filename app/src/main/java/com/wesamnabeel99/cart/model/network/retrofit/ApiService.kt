package com.wesamnabeel99.cart.model.network.retrofit

import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.category.CategoryResponse
import com.wesamnabeel99.cart.model.response.product.Product
import com.wesamnabeel99.cart.model.response.product.ProductsResponse
import com.wesamnabeel99.cart.model.response.users.UserResponse

interface ApiService {
    fun requestProductsOfCategory(categoryId: Int): State<ProductsResponse>
    fun requestProductDetails(productId: Int): State<Product>
    fun requestCategories(): State<CategoryResponse>
    fun requestUsers(): State<UserResponse>
}