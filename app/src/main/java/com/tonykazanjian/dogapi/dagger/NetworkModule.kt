package com.tonykazanjian.dogapi.dagger

import com.tonykazanjian.dogapi.ApiUtils
import com.tonykazanjian.dogapi.network.Api
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author Tony Kazanjian
 */
@Module
class NetworkModule {

    companion object{
        private const val NAME_BASE_URL = "NAME_BASE_URL"
    }

    @Provides
    @Singleton
    fun provideHttpClient() = OkHttpClient()

    @Provides
    @Singleton
    fun provideRequestBuilder(@Named(NAME_BASE_URL) baseUrl: String) = HttpUrl.parse(baseUrl)?.newBuilder()

    @Provides
    @Singleton
    fun provideApi(client: OkHttpClient, requestBuilder: HttpUrl.Builder?) = Api(client, requestBuilder)

    @Provides
    @Named(NAME_BASE_URL)
    fun provideBaseUrlString() = ApiUtils.BASE_URL
}