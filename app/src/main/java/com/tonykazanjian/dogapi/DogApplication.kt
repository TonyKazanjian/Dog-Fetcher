package com.tonykazanjian.dogapi

import android.app.Application
import com.tonykazanjian.dogapi.dagger.AppComponent
import com.tonykazanjian.dogapi.dagger.AppModule
import com.tonykazanjian.dogapi.dagger.DaggerAppComponent

/**
 * @author Tony Kazanjian
 */
class DogApplication: Application() {

    val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerAppComponent.builder().appModule(AppModule(this)).build()

    }
    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

}