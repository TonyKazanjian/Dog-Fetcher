package com.tonykazanjian.dogapi.dagger

import com.tonykazanjian.dogapi.network.DogApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author Tony Kazanjian
 */
@Module
class RestApiModule {

    @Provides
    @Singleton
    fun provideDogApi(@Named("dogRetrofit")dogRetrofit: Retrofit): DogApi = dogRetrofit.create(DogApi::class.java)
}