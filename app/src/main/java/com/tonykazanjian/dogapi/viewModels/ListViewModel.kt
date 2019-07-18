package com.tonykazanjian.dogapi.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tonykazanjian.dogapi.data.DataClasses
import com.tonykazanjian.dogapi.network.DogApi
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

/**
 * @author Tony Kazanjian
 */
class ListViewModel @Inject constructor(val api: DogApi): BaseViewModel() {

     val breeds: MutableLiveData<String> by lazy {
        MutableLiveData<String>().also {
            loadBreeds()
        }
    }

    fun getBreeds(): LiveData<String> {
        return breeds
    }

    private fun loadBreeds() {
        api.getAllDogBreeds()
    }
}