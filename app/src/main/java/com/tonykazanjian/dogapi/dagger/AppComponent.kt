package com.tonykazanjian.dogapi.dagger

import com.tonykazanjian.dogapi.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * @author Tony Kazanjian
 */
@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {

    fun inject(target: MainActivity)
}