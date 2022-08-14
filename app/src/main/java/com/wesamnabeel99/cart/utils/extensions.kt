package com.wesamnabeel99.cart.utils

import okhttp3.HttpUrl

fun HttpUrl.Builder.buildBaseUrl() = this.scheme(Constants.SCHEME)
    .host(Constants.HOST)
