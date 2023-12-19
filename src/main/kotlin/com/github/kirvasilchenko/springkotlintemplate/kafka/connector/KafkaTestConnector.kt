package com.github.kirvasilchenko.springkotlintemplate.kafka.connector

interface KafkaTestConnector {
    fun sendMessage(message: String)
}