package com.tonykazanjian.dogapi.dagger

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.tonykazanjian.dogapi.ApiUtils
import com.tonykazanjian.dogapi.data.DataClasses
import com.tonykazanjian.dogapi.network.DogListDeserializer
import dagger.Module
import dagger.Provides
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author Tony Kazanjian
 */
@Module
class NetworkModule {

    @Singleton
    @Provides
    @Named(value = "dogRetrofit")
    fun providesDogClient(): Retrofit {
        val customGson = GsonBuilder().registerTypeAdapter(DataClasses.Breed::class.java, DogListDeserializer("message")).create()
        return Retrofit.Builder()
            .baseUrl(ApiUtils.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(customGson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }
}