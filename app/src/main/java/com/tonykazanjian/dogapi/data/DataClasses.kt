package com.tonykazanjian.dogapi.data

import com.google.gson.annotations.SerializedName

/**
 * @author Tony Kazanjian
 */
class DataClasses {

    data class DogApiResponse(@SerializedName("message")var results: Any?)

    data class Breed(val name: String, val subBreeds: List<String>)
}