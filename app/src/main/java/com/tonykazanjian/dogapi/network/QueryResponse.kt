package com.tonykazanjian.dogapi.network

import android.os.Parcelable

/**
 * @author Tony Kazanjian
 */
interface QueryResponse: Parcelable {
    val status : String
    val queries : List<String>
}