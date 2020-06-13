package com.wordtarget;

import com.github.tomakehurst.wiremock.WireMockServer;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import java.util.Scanner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiWordTargetWireMock {

    private WireMockServer wireMockServer;
    private CloseableHttpClient httpClient = HttpClients.createDefault();

    private static final String BASE_PATH = "/word";
    private static final String ADD_WORD_PATH = "/word/add";
    private static final String APPLICATION_JSON = "application/json";

    @BeforeEach
    public void configureSystemUnderTest(){

        this.wireMockServer = new WireMockServer();
        this.wireMockServer.start();
        configureFor("localhost", 8080);
    }

    @AfterEach
    public void stopWireMockServer(){
        this.wireMockServer.stop();
    }

    private static String convertResponseToString(HttpResponse response) throws IOException {
        InputStream responseStream = response.getEntity().getContent();
        Scanner scanner = new Scanner(responseStream, "UTF-8");
        String stringResponse = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return stringResponse;
    }

    @Test
    public void createWordCorrect() throws IOException, ClassCastException{
        stubFor(post(urlEqualTo(ADD_WORD_PATH))
            .withHeader("Content-Type", equalTo(APPLICATION_JSON))
            .withRequestBody(containing("{word\": \"testen\"}"))
            .willReturn(aResponse()
            .withStatus(200)));

        StringEntity entity = new StringEntity("{word\": \"testen\"}");

        HttpPost request = new HttpPost("http://localhost:8080/word/add");
        request.addHeader("Content-Type", APPLICATION_JSON);
        request.setEntity(entity);
        CloseableHttpResponse response = httpClient.execute(request);

        verify(postRequestedFor(urlEqualTo(ADD_WORD_PATH))
                .withHeader("Content-Type", equalTo(APPLICATION_JSON)));

        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(200);
    }

    @Test
    public void createToLongWord() throws IOException, ClassCastException{
        stubFor(post(urlEqualTo(ADD_WORD_PATH))
                .withHeader("Content-Type", equalTo(APPLICATION_JSON))
                .withRequestBody(containing("{word\": \"testentesten\"}"))
                .willReturn(aResponse()
                        .withStatus(500)));

        StringEntity entity = new StringEntity("{word\": \"testentesten\"}");

        HttpPost request = new HttpPost("http://localhost:8080/word/add");
        request.addHeader("Content-Type", APPLICATION_JSON);
        request.setEntity(entity);
        CloseableHttpResponse response = httpClient.execute(request);

        verify(postRequestedFor(urlEqualTo(ADD_WORD_PATH))
                .withHeader("Content-Type", equalTo(APPLICATION_JSON)));

        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(500);
    }

    @Test
    public void createToShortWord() throws IOException, ClassCastException{
        stubFor(post(urlEqualTo(ADD_WORD_PATH))
                .withHeader("Content-Type", equalTo(APPLICATION_JSON))
                .withRequestBody(containing("{word\": \"tes\"}"))
                .willReturn(aResponse()
                        .withStatus(500)));

        StringEntity entity = new StringEntity("{word\": \"tes\"}");

        HttpPost request = new HttpPost("http://localhost:8080/word/add");
        request.addHeader("Content-Type", APPLICATION_JSON);
        request.setEntity(entity);
        CloseableHttpResponse response = httpClient.execute(request);

        verify(postRequestedFor(urlEqualTo(ADD_WORD_PATH))
                .withHeader("Content-Type", equalTo(APPLICATION_JSON)));

        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(500);
    }

    @Test
    public void createSpecialWord() throws IOException, ClassCastException{
        stubFor(post(urlEqualTo(ADD_WORD_PATH))
                .withHeader("Content-Type", equalTo(APPLICATION_JSON))
                .withRequestBody(containing("{word\": \"t@s+n\"}"))
                .willReturn(aResponse()
                        .withStatus(500)));

        StringEntity entity = new StringEntity("{word\": \"t@s+n\"}");

        HttpPost request = new HttpPost("http://localhost:8080/word/add");
        request.addHeader("Content-Type", APPLICATION_JSON);
        request.setEntity(entity);
        CloseableHttpResponse response = httpClient.execute(request);

        verify(postRequestedFor(urlEqualTo(ADD_WORD_PATH))
                .withHeader("Content-Type", equalTo(APPLICATION_JSON)));

        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(500);
    }
}

