package com.service;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

import java.io.IOException;

@Service
@SuppressWarnings("PMD.UselessParentheses")
public class ApiCallService {
    @Value("${api.url}")
    private String apiUrl;
    private static Logger logger = LoggerFactory.getLogger(ApiCallService.class);

    public Mono<String> create(String word){

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(apiUrl + "/" + word);

            CloseableHttpResponse response = client.execute(httpGet);
            assert (response.getStatusLine().getStatusCode() == 200);
//            client.close();
            return Mono.just(word);
        } catch (IOException e) {
            logger.error(String.format("The API failed, the following error is thrown: %s ", e.getMessage()));
            return Mono.error(e.fillInStackTrace());
        }
    }
}

