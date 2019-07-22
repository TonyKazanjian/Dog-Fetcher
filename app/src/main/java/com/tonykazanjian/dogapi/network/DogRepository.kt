package com.tonykazanjian.dogapi.network

import com.google.gson.JsonArray
import com.google.gson.JsonObject

/**
 * @author Tony Kazanjian
 */
class DogRepository(private val api: DogApi) : BaseRepository() {

    suspend fun getDogList() : JsonObject? {
        val dogResponse = safeApiCall(
            call = {api.getAllDogBreeds().await()},
            errorMessage = "Error fetching dog breeds"
        )
        return dogResponse?.result
    }

    suspend fun getBreedImages(breed: String): JsonArray? {
        val imageResponse = safeApiCall(
            call = {api.getBreedImages(breed).await()},
            errorMessage = "Error fetching breed images"
        )
        return imageResponse?.result
    }

    suspend fun getSubBreedImages(breed: String, subBreed: String): JsonArray? {
        val imageResponse = safeApiCall(
            call = {api.getSubBreedImages(breed, subBreed).await()},
            errorMessage = "Error fetching sub breed images"
        )
        return imageResponse?.result
    }
}