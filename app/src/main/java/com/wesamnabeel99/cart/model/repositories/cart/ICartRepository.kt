package com.wesamnabeel99.cart.model.repositories.cart

import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.category.CategoryResponse
import com.wesamnabeel99.cart.model.response.product.Product
import com.wesamnabeel99.cart.model.response.product.ProductsResponse
import com.wesamnabeel99.cart.model.response.users.UserResponse

interface ICartRepository {

    fun getProductsOfCategory(categoryId: Int): State<ProductsResponse>

    fun getProductDetails(productId: Int): State<Product>

    fun getCategories(): State<CategoryResponse>

    fun getUsers(): State<UserResponse>

}