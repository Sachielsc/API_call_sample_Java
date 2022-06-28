package com.charlessnippet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

// @Disabled("Disable as these are demo test cases")
public class TestHttpRequest
{
    Logger logger = LogManager.getLogger(TestHttpRequest.class);
    private HttpURLConnection httpURLConnection;
    String siteURL = "https://jsonplaceholder.typicode.com/albums";

    @BeforeAll
    public static void setUp() {
        // TODO
    }

    @BeforeEach
    public void configureTools() {
        
        logger.info("Start testing " + this.getClass().getSimpleName());
    }

    @AfterEach
    public void tearDown() {
        logger.info("Closing the test " + this.getClass().getSimpleName());
        logger.traceExit();
    }
    
    /**
     * <p>don't use this in your main thread</p>
     * <p>this is not asynchronous</p>
     */
    @Test
    public void test_http_request()
    {
        // String siteURL = "https://jsonplaceholder.typicode.com/albums";
        BufferedReader bufferedReader;
        String line;
        StringBuffer responseContent = new StringBuffer();

        try {
            URL url = new URL(siteURL);
            httpURLConnection = (HttpURLConnection) url.openConnection();

            // request setup
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);

            int status = httpURLConnection.getResponseCode();
            logger.info(status);

            if (status > 299) {
                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
                while ((line = bufferedReader.readLine()) != null) {
                    responseContent.append(line);
                }
                bufferedReader.close();
            } else {
                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                while ((line = bufferedReader.readLine()) != null) {
                    responseContent.append(line);
                }
                bufferedReader.close();
            }
            logger.info(responseContent.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpURLConnection.disconnect();
        }
    }

    /**
     * <p>this is asynchronous</p>
     */
    @Test
    public void test_http_request_java11() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(siteURL)).build();
        httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString())
        .thenApply(HttpResponse::body)
        .thenAccept(logger::info)
        .join();
    }
}
