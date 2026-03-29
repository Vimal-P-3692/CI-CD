package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testHelloEndpoint() {
        String response = restTemplate.getForObject("/", String.class);
        assertEquals("Hello World ...", response);
    }

    @Test
    void testHelloEndpoint1() {
        String response = restTemplate.getForObject("/say", String.class);
        assertEquals("Hello to you ...", response);
    }
}