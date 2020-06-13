package com.wordtarget;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient;

@AutoConfigureWebTestClient(timeout = "36000")
public class StatusGameApplicationEndToEndTest {

    private static WebTestClient webTestClient;

    @BeforeAll
    static void setUP(){
        webTestClient = WebTestClient.bindToServer().baseUrl("https://lolingo.herokuapp.com").build();
    }

    @Test
    public void testStatusGameApplication(){
        this.webTestClient
                .get()
                .uri("")
                .exchange()
                .expectStatus()
                .isOk();
    }
}

