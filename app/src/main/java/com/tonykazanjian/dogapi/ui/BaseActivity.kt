package com.tonykazanjian.dogapi.ui

import androidx.appcompat.app.AppCompatActivity
import com.tonykazanjian.dogapi.DogApplication
import com.tonykazanjian.dogapi.dagger.AppComponent
import com.tonykazanjian.dogapi.dagger.ViewModelFactory
import javax.inject.Inject

/**
 * @author Tony Kazanjian
 */
open class BaseActivity : AppCompatActivity() {

    @Inject
    protected lateinit var viewModeFactory: ViewModelFactory

    protected val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (this.application as DogApplication).appComponent
    }
}