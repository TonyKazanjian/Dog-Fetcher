package com.tonykazanjian.dogapi.viewModels

import androidx.lifecycle.ViewModel

/**
 * @author Tony Kazanjian
 */
open class BaseBreedViewModel<T>(item: T) : ViewModel() {
    open var name = item.toString()
}