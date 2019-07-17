package com.tonykazanjian.dogapi.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val breeds: MutableLiveData<List<String>> by lazy {
        MutableLiveData<List<String>>().also {
            loadBreeds()
        }
    }

    fun getBreeds(): LiveData<List<String>> {
        return breeds
    }

    private fun loadBreeds() {
        api.getBreedList().enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call?, response: Response?) {

                if (response?.isSuccessful == true) {
                    response.body()?.string()?.let{
                        Log.d("TONY", "breeds response: $it")
                    }
                }
            }
        })

    }
}