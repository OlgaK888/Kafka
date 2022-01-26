package com.example.controller;

import com.example.dto.UserDTO;
import com.example.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MsgController {

    private final ProducerService producerService;

    /*@GetMapping("/msg")
    public String msg(@RequestParam String message) {
        producerService.produce(message);
        return "OK";
    }*/

    /*@GetMapping("/msg")
    public void sendMsg(String message) {
        ListenableFuture<SendResult<Long, String>> future = kafkaTemplate1.send("messages", 1L, message);
        future.addCallback(System.out::println, System.err::println);
        kafkaTemplate1.flush();
    }*/

    @GetMapping("/dto")
    public UserDTO sendMsg(@RequestBody UserDTO userDTO) {
        producerService.produce(userDTO);
        return userDTO;
    }

    /*@GetMapping("/dto")
    public UserDTO sendMsg(@RequestBody UserDTO userDTO) {
        ListenableFuture<SendResult<Long, UserDTO>> future = kafkaTemplate2.send("messages", 1L, userDTO);
        future.addCallback(System.out::println, System.err::println);
        kafkaTemplate2.flush();
        return userDTO;
    }*/
}
