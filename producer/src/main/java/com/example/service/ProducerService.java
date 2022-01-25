package com.example.service;

import com.example.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerService {

    //private final KafkaTemplate<String, String> kafkaTemplate1;
    private final KafkaTemplate<Long, Object> kafkaTemplate2;

    /*public void produce(String message) {
        System.out.println("Producing the message: " + message);
        kafkaTemplate1.send("messages", "msg", message);
    }*/

    public void produce(UserDTO userDTO) {
        kafkaTemplate2.send("messages", 1L, userDTO);
    }
}
