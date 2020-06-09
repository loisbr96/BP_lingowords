package com.service;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Service
@SuppressWarnings("PMD.UselessParentheses")
public class ApiService {
    @Value("${api.url}")
    private String apiUrl;
//    WebClient webClient = WebClient.create(apiUrl);


    public Mono<String> create(String word) throws IOException {
        CloseableHttpClient client = null;
        try{
            client = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(apiUrl + "/" + word);


            CloseableHttpResponse response = client.execute(httpGet);
            assert(response.getStatusLine().getStatusCode()== 200);
        }
        finally {
            client.close();
        }
        return null;

    }
}

