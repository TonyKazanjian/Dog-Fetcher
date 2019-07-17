package com.tonykazanjian.dogapi.data

/**
 * @author Tony Kazanjian
 */
class DataClasses {

    data class BreedsResult(val message: List<Breed>)

    data class Breed(val name: String, val subBreeds: List<SubBreed>)

    data class SubBreed(val name: String)
}