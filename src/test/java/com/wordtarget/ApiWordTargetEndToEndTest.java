//package com.wordtarget;
//
//
//import org.junit.jupiter.api.Test;
//
//import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.reactive.server.WebTestClient;
//
//@AutoConfigureWebTestClient(timeout = "36000")
//@SpringBootTest
//public class ApiWordTargetEndToEndTest {
//
//    private static WebTestClient webTestClient;
//
//    @Before
//    static void setUP(){
//        webTestClient = WebTestClient.bindToServer().baseUrl("https://lolingo.herokuapp.com/word/add").build();
//    }
//
//    @Test
//    public void createCorrectWord(){
//        this.webTestClient.get().uri("/testen").exchange().expectStatus().isOk();
//    }
//
//    @Test
//    public void createToLongWord(){
//        this.webTestClient.get().uri("/testentesten").exchange().expectStatus().is5xxServerError();
//    }
//
//    @Test
//    public void createSpecialWord(){
//        this.webTestClient.get().uri("/t@st+n").exchange().expectStatus().is5xxServerError();
//    }
//}
//
