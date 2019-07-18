package com.tonykazanjian.dogapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tonykazanjian.dogapi.DogApplication
import com.tonykazanjian.dogapi.R
import com.tonykazanjian.dogapi.dagger.AppComponent
import com.tonykazanjian.dogapi.dagger.ViewModelFactory
import com.tonykazanjian.dogapi.databinding.ActivityMainBinding
import com.tonykazanjian.dogapi.viewModels.ListViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var viewModeFactory: ViewModelFactory
    private lateinit var listViewModel: ListViewModel

    val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (this.application as DogApplication).appComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        val activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.lifecycleOwner = this

        listViewModel = ViewModelProviders.of(this, viewModeFactory).get(ListViewModel::class.java)
        activityMainBinding.viewModel = listViewModel

        listViewModel.getBreeds().observe(this, Observer<String>{ breeds ->

            Log.d("TONY", "breeds list: " + breeds)
        })

        (application as DogApplication).appComponent.inject(this)

    }

    override fun onStart() {
        super.onStart()
//        listViewModel = ViewModelProviders.of(this)[ListViewModel::class.java]

//        showWelcomeDialog()
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
