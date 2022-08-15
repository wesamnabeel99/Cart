package com.wesamnabeel99.cart.model.network.client

import com.wesamnabeel99.cart.model.network.state.State
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request

class Client {
    private val okHttpClient = OkHttpClient()
    private val jsonParser = JsonParser()

    fun <T> requestData(httpUrl: HttpUrl, parsingResponseType: Class<T>): State<T>  {
        val request = buildRequest(httpUrl)
        val response = makeRequest(request)
        return if (response.isSuccessful) {
            val jsonString = response.body!!.string()
            val parsedResponse = jsonParser.parseResponse(jsonString, parsingResponseType)
            State.Success(parsedResponse)
        } else {
            State.Fail("response is not successful: ${response.message}")
        }
    }

    private fun buildRequest(httpUrl: HttpUrl) = Request.Builder().url(httpUrl).build()

    private fun makeRequest(request: Request) = okHttpClient.newCall(request).execute()

}