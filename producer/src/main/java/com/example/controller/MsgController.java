package com.example.controller;

import com.example.dto.UserDTO;
import com.example.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MsgController {

    private final ProducerService producerService;

    /*@GetMapping("/msg")
    public String msg(@RequestParam String message) {
        producerService.produce(message);
        return "OK";
    }*/

    @GetMapping("/dto")
    public UserDTO msg(@RequestBody UserDTO userDTO) {
        producerService.produce(userDTO);
        return userDTO;
    }
}
