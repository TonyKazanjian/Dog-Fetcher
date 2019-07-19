package com.tonykazanjian.dogapi.data

/**
 * @author Tony Kazanjian
 */
class DataClasses {

    data class DogApiResponse(var results: List<Breed>)

    data class Breed(val name: String, val subBreeds: List<String>)
}