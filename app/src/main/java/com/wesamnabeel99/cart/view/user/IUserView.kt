package com.wesamnabeel99.cart.view.user

import com.wesamnabeel99.cart.model.network.state.State
import com.wesamnabeel99.cart.model.response.product.Product
import com.wesamnabeel99.cart.model.response.product.ProductsResponse
import com.wesamnabeel99.cart.model.response.users.UserResponse
import com.wesamnabeel99.cart.view.base.IBaseView
import kotlinx.coroutines.flow.Flow

interface IUserView : IBaseView<UserResponse>