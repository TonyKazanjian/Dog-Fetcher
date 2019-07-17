package com.tonykazanjian.dogapi.network

import com.tonykazanjian.dogapi.ApiUtils
import okhttp3.Call
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import javax.inject.Inject

/**
 * @author Tony Kazanjian
 */
class Api @Inject constructor(private val client: OkHttpClient, private val requestBuilder: HttpUrl.Builder?) {

    fun getBreedList() : Call {
        val urlBuilder = requestBuilder
            ?.addPathSegments(ApiUtils.ALL_BREEDS)
            ?.addPathSegments(ApiUtils.LIST_ALL)

        return Request.Builder()
            .url(urlBuilder?.build())
            .get()
            .build()
            .let {
                client.newCall(it)
            }
    }
}