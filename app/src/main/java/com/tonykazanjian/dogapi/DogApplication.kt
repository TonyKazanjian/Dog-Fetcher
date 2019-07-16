package com.tonykazanjian.dogapi

import android.app.Application
import com.tonykazanjian.dogapi.dagger.AppComponent
import com.tonykazanjian.dogapi.dagger.AppModule
import com.tonykazanjian.dogapi.dagger.DaggerAppComponent

/**
 * @author Tony Kazanjian
 */
class DogApplication: Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger(this)
    }

    private fun initDagger(app: DogApplication): AppComponent =
        DaggerAppComponent.builder().appModule(AppModule(app)).build()
}