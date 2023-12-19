package com.github.kirvasilchenko.springkotlintemplate.kafka.consumer

import com.fasterxml.jackson.databind.ObjectMapper
import lombok.RequiredArgsConstructor
import org.apache.kafka.clients.consumer.ConsumerInterceptor
import org.apache.kafka.clients.consumer.ConsumerRecords
import org.apache.kafka.clients.consumer.OffsetAndMetadata
import org.apache.kafka.common.TopicPartition
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class TestConsumerInterceptor: ConsumerInterceptor<String, String> {

    private lateinit var mapper: ObjectMapper

    // Phase 0: set up
    override fun configure(p0: MutableMap<String, *>?) {
        println("[KAFKA][test][Consumer] configure event started")
        // I just wanted to put a bean into an interceptor
        mapper = p0!!["mapper"] as ObjectMapper
        println("[KAFKA][test][Consumer] configure event finished")
    }

    override fun close() {
        this.close()
    }

    // Phase 2: tell you've received messages
    override fun onCommit(p0: MutableMap<TopicPartition, OffsetAndMetadata>?) {
        println("[KAFKA][test][Consumer] onCommit event")
    }

    // Phase 1: actually read messages
    override fun onConsume(records: ConsumerRecords<String, String>?): ConsumerRecords<String, String> {
        println("[KAFKA][test][Consumer] onConsume event started")
        val result = records ?: ConsumerRecords.empty()
        result.forEach {
            it.value()?.let { println("[KAFKA][test][Consumer] message = ${it.replace(".+".toRegex(), "***")}") }
        }
        println("[KAFKA][test][Consumer] onConsume event finished")
        return result
    }
}