package com.wesamnabeel99.cart.model.network

import com.google.gson.Gson
import okhttp3.Response

class JsonParser {
    private val gson = Gson()
    fun <T> parseResponse(response: Response, parsingResponseType: Class<T>): State<T> {
        return if (response.isSuccessful) {
            val jsonString = response.body!!.string()
            val parsedResponse = gson.fromJson(jsonString, parsingResponseType)
            State.Success(parsedResponse)
        } else {
            State.Fail(response.message)
        }
    }
}