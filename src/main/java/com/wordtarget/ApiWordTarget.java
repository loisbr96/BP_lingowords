package com.wordtarget;

import com.service.WordTarget;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApiWordTarget implements WordTarget {
    @Value("${api.url}")
    private String apiUrl;
    private static Logger logger = LoggerFactory.getLogger(ApiWordTarget.class);

    public Mono<String> create(String word){

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost request = new HttpPost(apiUrl);

            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("word", word));

            request.setEntity(new UrlEncodedFormEntity(params));

            CloseableHttpResponse response = client.execute(request);
            assert(response.getStatusLine().getStatusCode() == 200);

            return Mono.just(word);
        } catch (IOException e) {
            logger.error(String.format("The API failed, the following error is thrown: %s ", e.getMessage()));
            return Mono.error(e.fillInStackTrace());
        }
    }
}

