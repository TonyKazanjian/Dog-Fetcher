package com.tonykazanjian.dogapi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.tonykazanjian.dogapi.DogApplication
import com.tonykazanjian.dogapi.dagger.AppComponent
import com.tonykazanjian.dogapi.dagger.ViewModelFactory
import javax.inject.Inject

/**
 * @author Tony Kazanjian
 */
abstract class BaseFragment: Fragment() {

    @Inject
    protected lateinit var viewModeFactory: ViewModelFactory

    protected val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (activity!!.application as DogApplication).appComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
    }
}