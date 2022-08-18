package com.wesamnabeel99.cart.utils.extensions

import com.wesamnabeel99.cart.utils.Constants
import okhttp3.HttpUrl

fun HttpUrl.Builder.buildBaseUrl() = this.scheme(Constants.SCHEME)
    .host(Constants.HOST).addPathSegments(Constants.API_PATH_SEGMENT)
