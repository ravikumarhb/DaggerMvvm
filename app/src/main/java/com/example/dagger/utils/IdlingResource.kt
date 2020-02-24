package com.example.dagger.utils

import androidx.test.espresso.idling.CountingIdlingResource

object IdlingResource {
    @JvmField
    val countingResource = CountingIdlingResource("resource")

    fun increment() {
        countingResource.increment()
    }

    fun decrement() {
        if (!countingResource.isIdleNow) {
            countingResource.decrement()
        }
    }

}