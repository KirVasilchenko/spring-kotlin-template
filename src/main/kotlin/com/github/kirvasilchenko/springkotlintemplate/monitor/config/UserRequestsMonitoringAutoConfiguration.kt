package com.github.kirvasilchenko.springkotlintemplate.monitor.config

import com.github.kirvasilchenko.springkotlintemplate.monitor.UserRequestsMonitoring
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

//@Configuration
//class UserRequestsMonitoringAutoConfiguration(
//    private val meterRegistry: MeterRegistry
//) {
//
//    @Bean
//    fun userRequestsMonitoring(meterRegistry: MeterRegistry) = UserRequestsMonitoring(meterRegistry)
//}