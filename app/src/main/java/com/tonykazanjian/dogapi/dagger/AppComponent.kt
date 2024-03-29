package com.tonykazanjian.dogapi.dagger

import com.tonykazanjian.dogapi.DogApplication
import com.tonykazanjian.dogapi.ui.BaseFragment
import com.tonykazanjian.dogapi.ui.BreedDetailFragment
import com.tonykazanjian.dogapi.ui.MainActivity
import com.tonykazanjian.dogapi.ui.SubBreedImageFragment
import dagger.Component
import javax.inject.Singleton

/**
 * @author Tony Kazanjian
 */
@Singleton
@Component(modules = [AppModule::class, RetrofitModule::class, RestApiModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(application: DogApplication)
    fun inject(target: MainActivity)
    fun inject(target: BaseFragment)
}