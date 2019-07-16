package com.tonykazanjian.dogapi.network

import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import javax.inject.Inject

/**
 * @author Tony Kazanjian
 */
class Api @Inject constructor(private val client: OkHttpClient, requestBuilder: HttpUrl.Builder?) {
}