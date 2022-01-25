package com.example.service;

import com.example.dto.UserDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@EnableKafka
@Service
public class ConsumerService {

    /*@KafkaListener(topics = "messages")
    public void consume(String message){
        System.out.println("Consuming the message: " + message);
    }*/

    @KafkaListener(topics = "messages")
    public void consume(ConsumerRecord<Long, UserDTO> record){
        System.out.println(record.partition());
        System.out.println(record.key());
        System.out.println(record.value());
    }
}
