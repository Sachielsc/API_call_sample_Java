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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;


// @Disabled("Disable as these are demo test cases")
public class TestHttpRequest
{
    Logger logger = LogManager.getLogger(TestHttpRequest.class);
    private HttpURLConnection httpURLConnection;

    @BeforeAll
    public static void setUp() {
        // TODO
    }

    @BeforeEach
    public void configureTools() {
        // initialise log4j
        // logger = LogManager.getLogger(DemoTests.class);
    }

    @AfterEach
    public void tearDown() {
        logger.info("Closing the test ...");
        logger.traceExit();
    }
    
    @Test
    @Tag("demo")
    public void test_utility()
    {        
        logger.info("Start testing http request ...");

        BufferedReader bufferedReader;
        String line;
        StringBuffer responseContent = new StringBuffer();

        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/albums");
            httpURLConnection = (HttpURLConnection) url.openConnection();

            // request setup
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);

            int status = httpURLConnection.getResponseCode();
            logger.info(status);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
