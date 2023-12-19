package com.github.kirvasilchenko.springkotlintemplate.kafka.producer.impl

import com.github.kirvasilchenko.springkotlintemplate.kafka.producer.KafkaTestProducer
import lombok.RequiredArgsConstructor
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service("defaultKafkaTestProducer")
@RequiredArgsConstructor
class KafkaTestProducerImpl(
    private val kafkaTemplate: KafkaTemplate<String, String>
) : KafkaTestProducer {

    override fun sendMessage(message: String) {
        val future = kafkaTemplate.send("test", message)
        future.whenComplete { result, exception ->
            if (exception == null) {
                println("Sent message=[$message] with offset=[${result.recordMetadata.offset()}]")
            } else {
                println("Unable to send message=[$message] due to: ${exception.message}")
            }
        }
    }
}