package com.tonykazanjian.dogapi.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tonykazanjian.dogapi.network.Failure

/**
 * @author Tony Kazanjian
 */
abstract class BaseViewModel : ViewModel() {
    var failure: MutableLiveData<Failure> = MutableLiveData()

    protected fun handleFailure(failure: Failure) {
        this.failure.value = failure
    }
}