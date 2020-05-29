package com.service;

import org.apache.http.HttpConnection;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


@Service
public class ApiService {
    @Value("${api.url}")
    private String apiUrl;
    WebClient webClient = WebClient.create(apiUrl);

//TODO api call werkend krijgen
    public Mono<String> create(String word) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(apiUrl + "/" + word);


        CloseableHttpResponse response = client.execute(httpGet);
        assert(response.getStatusLine().getStatusCode()== 200);
        client.close();


        return null;

    }
}


//        return webClient.post()
//                .uri("/word/add")
//                .body(Mono.just(word), String.class)
//                .exchange()
//                .flatMap(clientResponse -> {
//                    if(clientResponse.statusCode().is5xxServerError()){
//                        clientResponse.body((clientHttpResponse, context) -> clientHttpResponse.getBody());
//                        return clientResponse.bodyToMono(String.class);
//                    }
//                    else {
//                        return clientResponse.bodyToMono(String.class);
//                    }
//                });
