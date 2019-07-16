package com.tonykazanjian.dogapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tonykazanjian.dogapi.DogApplication
import com.tonykazanjian.dogapi.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as DogApplication).appComponent.inject(this)
    }

    override fun onStart() {
        super.onStart()
        showWelcomeDialog()
    }

    private fun showWelcomeDialog() {
        val fragmentManager = this.supportFragmentManager
        fragmentManager.beginTransaction()
            .add(
                WelcomeDialog.newInstance(),
                WelcomeDialog.TAG
            )
            .commit()
    }

}
