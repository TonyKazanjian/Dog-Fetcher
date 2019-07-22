package com.tonykazanjian.dogapi.viewModels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.tonykazanjian.dogapi.R
import com.tonykazanjian.dogapi.data.DataClasses
import com.tonykazanjian.dogapi.network.DogApi
import com.tonykazanjian.dogapi.network.DogRepository
import kotlinx.android.synthetic.main.fragment_detail.view.*
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Tony Kazanjian
 */
class DetailViewModel @Inject constructor(api: DogApi, private val context: Context): ViewModel() {

    private val repository : DogRepository = DogRepository(api)

    var urlList = mutableListOf<String>()

    lateinit var breed: DataClasses.Breed

    private val urlLiveData: MutableLiveData<List<String>> by lazy {
        MutableLiveData<List<String>>().also {
            loadImageUrls()
        }
    }

    fun getImageUrlLiveData(): LiveData<List<String>> {
        return urlLiveData
    }

    fun subBreedListTitle(): String {
        return context.getString(R.string.subBreedText, breed.name)
    }

    private fun loadImageUrls(){
        viewModelScope.launch {
            val jsonArray = repository.getBreedImages(breed.name)
            val gson = Gson()
            val imageList = gson.fromJson(jsonArray, Array<String>::class.java).toList()
            urlList.addAll(imageList)
            urlLiveData.postValue(urlList)
        }
    }
}