package com.tonykazanjian.dogapi.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.tonykazanjian.dogapi.data.DataClasses
import com.tonykazanjian.dogapi.network.Api
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

/**
 * @author Tony Kazanjian
 */
class ListViewModel @Inject constructor(val api: Api): BaseViewModel() {

     val breeds: MutableLiveData<String> by lazy {
        MutableLiveData<String>().also {
            loadBreeds()
        }
    }

    fun getBreeds(): LiveData<String> {
        return breeds
    }

    private fun loadBreeds() {
        api.getBreedList().enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("failure.postValue(e.toString())\n") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call?, response: Response?) {

                if (response?.isSuccessful == true) {
                    val gson = Gson()
                    val json = gson.toJson(response)
                    val breedList = gson.fromJson(json, DataClasses.BreedsResult::class.java)
                    Log.d("TONY", "Breed list size = " + breedList)
                }
            }
        })

    }
}