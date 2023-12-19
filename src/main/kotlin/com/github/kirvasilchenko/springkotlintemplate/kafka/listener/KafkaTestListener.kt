package com.github.kirvasilchenko.springkotlintemplate.kafka.listener

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaTestListener {

    @KafkaListener(
        groupId = "test",
        topics = ["test"],
        containerFactory = "kafkaListenerContainerFactory"
    )
    fun logTestTopic(testEvent: ConsumerRecord<String, String>) {
        println("[KAFKA] Requested info on user ID = ${testEvent.value()}")
    }

}