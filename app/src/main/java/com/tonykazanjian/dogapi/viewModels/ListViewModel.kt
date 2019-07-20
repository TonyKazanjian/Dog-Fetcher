package com.tonykazanjian.dogapi.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tonykazanjian.dogapi.data.DataClasses
import com.tonykazanjian.dogapi.network.DogApi
import com.tonykazanjian.dogapi.network.DogRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/**
 * @author Tony Kazanjian
 */
class ListViewModel @Inject constructor(api: DogApi): BaseViewModel() {

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

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
        scope.launch {
            val breeds = repository.getDogList()
            breeds?.entrySet()?.map {
                val breedName = it.key
                val subBreedList = mutableListOf(it.value.toString())
                breedList.add(DataClasses.Breed(breedName, subBreedList))
            }
            breedsLiveData.postValue(breedList)
        }
    }
}