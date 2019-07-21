package com.tonykazanjian.dogapi.viewModels

import androidx.lifecycle.MutableLiveData
import com.tonykazanjian.dogapi.data.DataClasses

/**
 * @author Tony Kazanjian
 */
class ItemViewModel(breed: DataClasses.Breed) : BaseViewModel(){
    var name = breed.name
}