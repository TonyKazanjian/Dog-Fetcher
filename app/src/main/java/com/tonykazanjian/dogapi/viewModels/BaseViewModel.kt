package com.tonykazanjian.dogapi.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tonykazanjian.dogapi.network.Result
import kotlinx.coroutines.*

/**
 * @author Tony Kazanjian
 */
abstract class BaseViewModel : ViewModel() {

//    var result: MutableLiveData<Result> = MutableLiveData()
//
//    protected fun handleFailure(result: Result) {
//        this.result.value = result
//    }
}