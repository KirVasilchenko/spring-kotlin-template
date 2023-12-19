package com.github.kirvasilchenko.springkotlintemplate.kafka.consumer

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.annotation.PartitionOffset
import org.springframework.kafka.annotation.TopicPartition
import org.springframework.stereotype.Service

@Service
class KafkaTestConsumer {

    @KafkaListener(
        groupId = "test",
        //the simplest way to declare a topic:
        // topics = ["test"],
        containerFactory = "kafkaListenerContainerFactory",
        // but we have to declare topic partitions to receive messages from and offsets to start from since every startup
        topicPartitions = [
            TopicPartition(
                topic = "test",
                //XXX: set to 0, so we can test consumer interceptor by only starting application
                partitionOffsets = [PartitionOffset(partition = "0", initialOffset = "0")]
            )
        ],
    )
    fun logTestTopic(testEvent: ConsumerRecord<String, String>) {
        println("[KAFKA] Requested info on user ID = ${testEvent.value()}")
    }

}