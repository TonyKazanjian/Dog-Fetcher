package com.tonykazanjian.dogapi.viewModels

import androidx.lifecycle.ViewModel

/**
 * @author Tony Kazanjian
 */
open class BaseViewModel<T>(item: T) : ViewModel() {

    open var name = item.toString()

//    var result: MutableLiveData<Result> = MutableLiveData()
//
//    protected fun handleFailure(result: Result) {
//        this.result.value = result
//    }
}