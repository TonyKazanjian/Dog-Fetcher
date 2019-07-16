package com.tonykazanjian.dogapi.dagger

import com.tonykazanjian.dogapi.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * @author Tony Kazanjian
 */
@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(target: MainActivity)
}