package com.tonykazanjian.dogapi.data

import com.google.gson.annotations.SerializedName
import okhttp3.Response

/**
 * @author Tony Kazanjian
 */
class DataClasses {

    data class BreedsResult(@SerializedName("message") val list : List<String>)

    data class Breed(val name: String, val subBreeds: List<SubBreed>)

    data class SubBreed(val name: String)
}