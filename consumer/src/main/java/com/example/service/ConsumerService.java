package com.example.service;

import com.example.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@EnableKafka
@Service
@RequiredArgsConstructor
public class ConsumerService {

    private final KafkaTemplate<Long, UserDTO> kafkaTemplate;

    /*@KafkaListener(topics = "messages")
    public void consume(String message){
        System.out.println("Consuming the message: " + message);
    }*/

    @KafkaListener(topics = "messages1")
    public void consume(UserDTO userDTO, ConsumerRecord<Long, UserDTO> record){
        System.out.println(record.partition());
        System.out.println(record.key());
        System.out.println(record.value());
        produce(changeDTO(userDTO));
        //System.out.println(changeDTO(userDTO));
    }

    public UserDTO changeDTO (UserDTO userDTO) {
        userDTO.getName().toUpperCase();
        userDTO.setName(userDTO.getName().toUpperCase());
        return userDTO;
    }

    public void produce(UserDTO userDTO) {
        ListenableFuture<SendResult<Long, UserDTO>> future = kafkaTemplate.send("messages2", 2L, userDTO);
        future.addCallback(System.out::println, System.err::println);
        kafkaTemplate.flush();
    }
}
