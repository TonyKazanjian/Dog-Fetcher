package com.tonykazanjian.dogapi.network

import com.google.gson.JsonObject
import com.tonykazanjian.dogapi.data.DataClasses
import org.json.JSONObject

/**
 * @author Tony Kazanjian
 */
class DogRepository(private val api: DogApi) : BaseRepository() {

    suspend fun getDogList() : JsonObject? {
        val dogResponse = safeApiCall(
            call = {api.getAllDogBreeds().await()},
            errorMessage = "Error fetching dog breedsLiveData"
        )

        return dogResponse?.result
    }
}