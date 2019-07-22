package com.tonykazanjian.dogapi.viewModels

import androidx.lifecycle.MutableLiveData
import com.tonykazanjian.dogapi.data.DataClasses

/**
 * @author Tony Kazanjian
 */
class ItemViewModel(breed: DataClasses.Breed) : BaseViewModel<DataClasses.Breed>(breed) {
    override var name = breed.name
}