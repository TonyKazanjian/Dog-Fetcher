package com.tonykazanjian.dogapi.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.tonykazanjian.dogapi.network.DogApi
import com.tonykazanjian.dogapi.network.DogRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Tony Kazanjian
 */
class DetailViewModel @Inject constructor(api: DogApi): BaseViewModel() {

    private val repository : DogRepository = DogRepository(api)

    var urlList = mutableListOf<String>()

    private val urlLiveData: MutableLiveData<List<String>> by lazy {
        MutableLiveData<List<String>>().also {
            loadImageUrls()
        }
    }

    fun getImageUrlLiveData(): LiveData<List<String>> {
        return urlLiveData
    }

    private fun loadImageUrls(){
        viewModelScope.launch {
            val jsonArray = repository.getBreedImages("pug")
            val gson = Gson()
            val imageList = gson.fromJson(jsonArray, Array<String>::class.java).toList()
            urlList.addAll(imageList)
            urlLiveData.postValue(urlList)
        }

    }

}