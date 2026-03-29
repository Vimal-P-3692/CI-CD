package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello World ...";
    }

    @GetMapping("/say")
    public String sayHello() {
        return "Hello to you ...";
    }

    @GetMapping("/black")
    public String sayBlack() {
        return "Hello Black ...";
    }
}