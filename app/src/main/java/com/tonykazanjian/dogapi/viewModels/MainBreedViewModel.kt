package com.tonykazanjian.dogapi.viewModels

import com.tonykazanjian.dogapi.data.DataClasses

/**
 * @author Tony Kazanjian
 */
class MainBreedViewModel(breed: DataClasses.Breed) : BaseBreedViewModel<DataClasses.Breed>(breed) {
    override var name = breed.name
}