package com.tonykazanjian.dogapi.network

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.tonykazanjian.dogapi.data.DataClasses
import java.lang.reflect.Type

/**
 * @author Tony Kazanjian
 */
class DogListDeserializer(val root: String) : JsonDeserializer<DataClasses.DogApiResponse> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): DataClasses.DogApiResponse {
        val root = json?.asJsonObject?.get(root)?.asJsonObject
        val breedList = Gson().fromJson(root, DataClasses.DogApiResponse::class.java)
        return breedList
    }
}