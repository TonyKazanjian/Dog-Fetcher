package com.tonykazanjian.dogapi.viewModels

import android.content.Context
import com.google.gson.JsonArray
import com.tonykazanjian.dogapi.network.DogApi
import com.tonykazanjian.dogapi.network.DogRepositoryImpl
import javax.inject.Inject

/**
 * @author Tony Kazanjian
 */
class SubBreedImageViewModel @Inject constructor(var dogRepositoryImpl: DogRepositoryImpl, context: Context): DetailViewModel(dogRepositoryImpl, context){

    lateinit var subBreed: String

    override suspend fun getImageResponse(): JsonArray? {
        val jsonArray = dogRepositoryImpl.getSubBreedImages(breed.name, subBreed)
        return jsonArray
    }
}