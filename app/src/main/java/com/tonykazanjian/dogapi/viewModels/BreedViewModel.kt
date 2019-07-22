package com.tonykazanjian.dogapi.viewModels

import com.tonykazanjian.dogapi.data.DataClasses

/**
 * @author Tony Kazanjian
 */
class BreedViewModel(breed: DataClasses.Breed) : BaseViewModel<DataClasses.Breed>(breed) {
    override var name = breed.name
}