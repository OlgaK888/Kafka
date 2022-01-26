package com.example.service;

import com.example.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class ProducerService {

    //private final KafkaTemplate<Long, String> kafkaTemplate1;
    private final KafkaTemplate<Long, UserDTO> kafkaTemplate2;

    /*public void produce(String message) {
        ListenableFuture<SendResult<Long, String>> future = kafkaTemplate1.send("messages", 1L, message);
        future.addCallback(System.out::println, System.err::println);
        kafkaTemplate1.flush();
    }*/

    public void produce(@RequestBody UserDTO userDTO) {
        ListenableFuture<SendResult<Long, UserDTO>> future = kafkaTemplate2.send("messages", 1L, userDTO);
        future.addCallback(System.out::println, System.err::println);
        kafkaTemplate2.flush();
    }
}
