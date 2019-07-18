package com.tonykazanjian.dogapi.network

import androidx.lifecycle.LiveData
import com.tonykazanjian.dogapi.ApiUtils
import com.tonykazanjian.dogapi.data.DataClasses
import retrofit2.Call
import retrofit2.http.GET

/**
 * @author Tony Kazanjian
 */
interface DogApi {

//    @GET(value = "breed/{breed}/{sbreed}/images")
//    fun getDogImages(@Path("breed") breed: String, @Path("sbreed") sbreed: String): Observable<DogImageResponse>

    @GET(value = ApiUtils.ALL_BREEDS)
    fun getAllDogBreeds(): Call<DataClasses.DogApiResponse>
}