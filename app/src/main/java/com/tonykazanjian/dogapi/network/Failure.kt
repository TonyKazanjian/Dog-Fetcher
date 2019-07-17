package com.tonykazanjian.dogapi.network

/**
 * @author Tony Kazanjian
 */
sealed class Failure {

    object NetworkConnection : Failure()
    object ServerError : Failure()

    abstract class ApiFetchFailure: Failure()
}