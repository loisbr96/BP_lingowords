package com.wireMock;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
//import wiremock.org.apache.http.client.methods.HttpPost;
import wiremock.org.apache.http.client.methods.HttpPost;
import wiremock.org.apache.http.entity.StringEntity;

//import static com.github.tomakehurst.wiremock.client.WireMock.givenThat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static org.assertj.core.api.Assertions.assertThat;

public class WireMockConfigurationTest {

    private WireMockServer wireMockServer;
    private CloseableHttpClient httpClient = HttpClients.createDefault();

    private static final String BASE_PATH = "/word";
    private static final String ADD_WORD_PATH = "/word/add";

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

    @Test
    public void getAllWordsCorrect() throws IOException{
        String jsonReponse = "[" +
                "{\"id\":1,\"word\":\"aagje\"}," +
                "{\"id\":2,\"word\":\"aaibaar\"}" +
                "]";
        stubFor(get(urlEqualTo(BASE_PATH)).willReturn(aResponse().withBody(jsonReponse)));

        HttpGet request = new HttpGet("http://localhost:8080/word");
        HttpResponse response = httpClient.execute(request);
        String stringResponse = convertResponseToString(response);

        verify(getRequestedFor(urlEqualTo(BASE_PATH)));
        assertThat(jsonReponse).isEqualTo(stringResponse);
    }

    @Test
    public void getAllWordsIncorrect() throws IOException{
        String jsonReponse = "[" +
                "{\"id\":1,\"word\":\"aagje\"}," +
                "{\"id\":2,\"word\":\"aaibaar\"}" +
                "]";
        stubFor(get(urlEqualTo(BASE_PATH)).willReturn(aResponse().withBody(jsonReponse)));

        HttpGet request = new HttpGet("http://localhost:8080/word");
        HttpResponse response = httpClient.execute(request);
        String stringResponse = convertResponseToString(response);

        verify(getRequestedFor(urlEqualTo(BASE_PATH)));
        assertThat("[]").isNotEqualTo(stringResponse);
    }
    @Test
    public void addCorrectWord() throws IOException{
        String jsonReponse =
                "{\"id\":1,\"word\":\"aagje\"}";

        stubFor(get(urlEqualTo(ADD_WORD_PATH + "/aagje")).willReturn(aResponse().withBody(jsonReponse)));

        HttpGet request = new HttpGet("http://localhost:8080/word/add/aagje");
        HttpResponse response = httpClient.execute(request);
        String stringResponse = convertResponseToString(response);

        verify(getRequestedFor(urlEqualTo(ADD_WORD_PATH + "/aagje")));
        assertThat(jsonReponse).isEqualTo(stringResponse);
    }

//    @Test
//    public void addWordCorrectPost() throws IOException{
//
//
//        stubFor(post(urlEqualTo(ADD_WORD_PATH))
//            .withHeader("Content-Type", equalTo("application/json"))
//            .withRequestBody(containing("\"word\": \"testen\""))
//            .willReturn(aResponse()
//            .withStatus(200)));
//
//        StringEntity entity = new StringEntity("{word\": \"testen\"}");
//
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpPost request = new HttpPost("http://localhost:8080/word/add");
//        request.addHeader("Content-Type", "application/json");
//        request.setEntity(entity);
//        HttpResponse response = httpClient.execute((HttpUriRequest) request);
//
//
//        verify(postRequestedFor(urlEqualTo("/word/add"))
//                .withHeader("Content-Type", equalTo("application/json")));
//        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(200);
//
//    }

    private String convertInputStreamToString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        String string = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return string;
    }

    private static String convertResponseToString(HttpResponse response) throws IOException {
        InputStream responseStream = response.getEntity().getContent();
        Scanner scanner = new Scanner(responseStream, "UTF-8");
        String stringResponse = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return stringResponse;
    }
}

