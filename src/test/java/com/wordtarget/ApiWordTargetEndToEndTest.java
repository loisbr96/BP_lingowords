package com.wordtarget;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient;

@AutoConfigureWebTestClient(timeout = "36000")
public class ApiWordTargetEndToEndTest {

    private static WebTestClient webTestClient;

    @BeforeAll
    static void setUP(){
        webTestClient = WebTestClient.bindToServer().baseUrl("https://lolingo.herokuapp.com/word/add").build();
    }

    @Test
    public void createCorrectWord(){
        this.webTestClient
                .get()
                .uri("/testen")
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    public void createToLongWord(){
        this.webTestClient
                .get()
                .uri("/testentesten")
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

    @Test
    public void createToShortWord(){
        this.webTestClient
                .get()
                .uri("/test")
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

    @Test
    public void createSpecialWord(){
        this.webTestClient
                .get()
                .uri("/t@st+n")
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }
}

