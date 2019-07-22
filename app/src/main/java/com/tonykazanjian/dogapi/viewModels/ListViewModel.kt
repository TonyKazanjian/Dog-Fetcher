package com.tonykazanjian.dogapi.viewModels

import android.provider.Contacts
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.tonykazanjian.dogapi.data.DataClasses
import com.tonykazanjian.dogapi.network.DogApi
import com.tonykazanjian.dogapi.network.DogRepository
import com.tonykazanjian.dogapi.network.Result
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

/**
 * @author Tony Kazanjian
 */
class ListViewModel @Inject constructor(api: DogApi): ViewModel() {

    private val repository : DogRepository = DogRepository(api)

    private val breedList = mutableListOf<DataClasses.Breed>()

    private val breedsLiveData: MutableLiveData<List<DataClasses.Breed>> by lazy {
        MutableLiveData<List<DataClasses.Breed>>().also {
            loadBreeds()
        }
    }

    fun getBreedsLiveData(): LiveData<List<DataClasses.Breed>> {
        return breedsLiveData
    }

    private fun loadBreeds() {
        viewModelScope.launch {
            val breeds = repository.getDogList()
            breeds?.entrySet()?.map {
                val breedName = it.key
                val subBreedArray = it.value.asJsonArray
                val gson = Gson()
                val subBreedList = gson.fromJson(subBreedArray, Array<String>::class.java).toList()
                breedList.add(DataClasses.Breed(breedName, subBreedList))
            }

            breedsLiveData.postValue(breedList)
        }
    }
}