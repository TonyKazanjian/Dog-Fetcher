package com.tonykazanjian.dogapi.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
class ListViewModel @Inject constructor(val api: DogApi): BaseViewModel() {

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val repository : DogRepository = DogRepository(api)


    val breedsLiveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>().also {
            loadBreeds()
        }
    }

    fun getBreedsLiveData(): LiveData<String> {
        return breedsLiveData
    }

    private fun loadBreeds() {
        scope.launch {
            val breeds = repository.getDogList()
            breedsLiveData.postValue(breeds.toString())
        }
    }
}