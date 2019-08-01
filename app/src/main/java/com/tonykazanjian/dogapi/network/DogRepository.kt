package com.tonykazanjian.dogapi.network

import com.google.gson.JsonArray
import com.google.gson.JsonObject

/**
 * @author Tony Kazanjian
 */
interface DogRepository {

    suspend fun getDogList() : JsonObject?
    suspend fun getBreedImages(breed: String): JsonArray?
    suspend fun getSubBreedImages(breed: String, subBreed: String): JsonArray?
}