package com.tonykazanjian.dogapi.viewModels

import android.content.Context
import com.google.gson.JsonArray
import com.tonykazanjian.dogapi.network.DogApi
import javax.inject.Inject

/**
 * @author Tony Kazanjian
 */
class SubBreedImageViewModel @Inject constructor(api: DogApi, context: Context): DetailViewModel(api, context){

    lateinit var subBreed: String

    override suspend fun getImageResponse(): JsonArray? {
        val jsonArray = repository.getSubBreedImages(breed.name, subBreed)
        return jsonArray
    }
}