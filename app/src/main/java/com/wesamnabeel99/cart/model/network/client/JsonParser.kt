package com.wesamnabeel99.cart.model.network.client

import com.google.gson.Gson

class JsonParser {
    private val gson = Gson()
    fun <T> parseResponse(jsonString: String, parsingResponseType: Class<T>): T {
        return gson.fromJson(jsonString, parsingResponseType)
    }
}