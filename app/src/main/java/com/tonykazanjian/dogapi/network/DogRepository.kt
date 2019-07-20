package com.tonykazanjian.dogapi.network

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
}