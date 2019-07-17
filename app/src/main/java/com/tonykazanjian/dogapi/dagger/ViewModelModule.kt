package com.tonykazanjian.dogapi.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tonykazanjian.dogapi.network.Api
import com.tonykazanjian.dogapi.viewModels.ListViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton

/**
 * @author Tony Kazanjian
 */
@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    abstract fun bindMyViewModel(listViewModel: ListViewModel): ViewModel
}