package com.wesamnabeel99.cart.model.network.client

import android.util.Log
import com.google.gson.Gson
import com.wesamnabeel99.cart.model.network.State
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request

class Client {
    private val okHttpClient = OkHttpClient()
    private val gson = Gson()

    fun <T> requestData(url: HttpUrl, classOfTypeT: Class<T>): State<T> {
        val request = buildRequest(url)
        val response = makeRequest(request)
        return if (response.isSuccessful) {
            val jsonString = response.body!!.string()

            val response = gson.fromJson(jsonString, classOfTypeT)
            Log.i("CLIENT", "parsed response: $jsonString")
            State.Success(response)
        } else {
            State.Fail(response.message)
        }
    }

    private fun buildRequest(httpUrl: HttpUrl) = Request.Builder().url(httpUrl).build()

    private fun makeRequest(request: Request) = okHttpClient.newCall(request).execute()


}