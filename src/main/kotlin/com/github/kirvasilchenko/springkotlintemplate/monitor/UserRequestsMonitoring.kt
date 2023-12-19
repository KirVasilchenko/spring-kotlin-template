package com.github.kirvasilchenko.springkotlintemplate.monitor

import io.micrometer.core.instrument.MeterRegistry
import org.springframework.stereotype.Component

@Component
class UserRequestsMonitoring(
    meterRegistry: MeterRegistry
) {

    private val counter = meterRegistry.counter("user.requests")

    fun increment() {
        counter.increment()
    }

    fun ping() {
        println("ping")
    }

}