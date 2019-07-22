package com.tonykazanjian.dogapi.ui

import android.os.Bundle
import com.tonykazanjian.dogapi.data.DataClasses

/**
 * @author Tony Kazanjian
 */
class Navigator {

    companion object{
        const val BREED_KEY = "BREED_KEY"
    }

    fun showBreedDetails(activity: BaseActivity, breed: DataClasses.Breed){
        val fragmentManager = activity.supportFragmentManager
        val args = Bundle()
        args.putParcelable(BREED_KEY, breed)
    }
}