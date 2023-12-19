package com.github.kirvasilchenko.springkotlintemplate.kafka.producer

import com.fasterxml.jackson.databind.ObjectMapper
import lombok.RequiredArgsConstructor
import org.apache.kafka.clients.producer.ProducerInterceptor
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer.RecordMetadata
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class TestProducerInterceptor: ProducerInterceptor<String, String> {

    private lateinit var mapper: ObjectMapper

    override fun configure(configs: MutableMap<String, *>?) {
        println("[KAFKA][test][Producer] configure event started")
        mapper = configs!!["mapper"] as ObjectMapper
        println("[KAFKA][test][Producer] configure event finished")
    }

    override fun close() {
        this.close()
    }

    override fun onAcknowledgement(metadata: RecordMetadata?, exception: Exception?) {
        println("[KAFKA][test][Producer] acknowledgement event")
    }

    override fun onSend(record: ProducerRecord<String, String>?): ProducerRecord<String, String> {
        println("[KAFKA][test][Producer] onConsume event started")
        record?.let { println("[KAFKA][test][Producer] message = ${it.value().replace(".*?".toRegex(), "***")}") }
        println("[KAFKA][test][Producer] onConsume event finished")

        //assuming that we always have an actual record, when the method is called
        return record!!
    }

}