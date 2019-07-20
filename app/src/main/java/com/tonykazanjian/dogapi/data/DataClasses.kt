package com.tonykazanjian.dogapi.data

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import org.json.JSONObject

/**
 * @author Tony Kazanjian
 */
class DataClasses {

    data class DogApiResponse(@SerializedName("message")var result: JsonObject?)

    data class Breed(val name: String, val subBreeds: List<String>)
}