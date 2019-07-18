package com.tonykazanjian.dogapi.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.tonykazanjian.dogapi.network.QueryResponse
import okhttp3.Response

/**
 * @author Tony Kazanjian
 */
class DataClasses {

    data class DogApiResponse(@SerializedName("status")
                              override var status : String,
                              @SerializedName("message")
                              override var queries: List<String>): QueryResponse {
        constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.createStringArrayList()
        ) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(status)
            parcel.writeStringList(queries)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<DogApiResponse> {
            override fun createFromParcel(parcel: Parcel): DogApiResponse {
                return DogApiResponse(parcel)
            }

            override fun newArray(size: Int): Array<DogApiResponse?> {
                return arrayOfNulls(size)
            }
        }


    }

    data class Breed(val name: String, val subBreeds: List<SubBreed>)

    data class SubBreed(val name: String)
}