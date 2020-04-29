package com;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class SpringBootLiveTest {
    private static final String API_ROOT = "http://localhost:8080/api/word";


    @Test
    public void whenGetAllWords_thenOK() {
        final Response response = RestAssured.get(API_ROOT);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

}
