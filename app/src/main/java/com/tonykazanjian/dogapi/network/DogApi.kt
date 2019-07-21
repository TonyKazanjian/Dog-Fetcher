package com.tonykazanjian.dogapi.network

import androidx.lifecycle.LiveData
import com.tonykazanjian.dogapi.ApiUtils
import com.tonykazanjian.dogapi.data.DataClasses
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Tony Kazanjian
 */
interface DogApi {

    @GET(value = "${ApiUtils.SINGLE_BREED}/{breed}/${ApiUtils.IMAGES}")
    fun getDogImages(@Path("breed") breed: String): Deferred<Response<DataClasses.DogApiImageResponse>>

    @GET(value = ApiUtils.ALL_BREEDS)
    fun getAllDogBreeds(): Deferred<Response<DataClasses.DogApiResponse>>
}