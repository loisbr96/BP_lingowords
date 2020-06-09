//package com.service;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.reactive.server.WebTestClient;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ApiServiceEndToEndTest {
//
//    private WebTestClient webTestClient;
//
//    @Before
//    public void setUP(){
//        webTestClient = WebTestClient.bindToServer().baseUrl("https://lolingo.herokuapp.com/word/add").build();
//    }
//
//    @Test
//    public void create(){
//        this.webTestClient.get().uri("/testen").exchange().expectStatus().isOk();
//    }
//}
