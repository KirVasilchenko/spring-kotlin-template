package com.github.kirvasilchenko.springkotlintemplate.kafka.producer

interface KafkaTestProducer {
    fun sendMessage(message: String)
}