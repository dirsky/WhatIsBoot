package com.frank.boot.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestTestControllerTest {

    public static final String URL = "http://localhost";

    @LocalServerPort
    private int port = 8080;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RestTestController helloWordController;

    /**
     * 方式1：直接对接class
     */
    @Test
    public void index() {
        String string = helloWordController.get("frank");
        Assert.assertEquals("get frank", string);
        Assert.assertEquals("get candy", string);
    }

    /**
     * 方式2：通过RestTemplate的方式进行
     */
    @Test
    public void get() {
        String RequestUrl = URL + ":" + port + "/hello/get?name=frank";
        String object = restTemplate.getForObject(RequestUrl, String.class);
        Assert.assertEquals("get frank", object);
    }

    @Test
    public void post() {
        String post = helloWordController.post("frank");
        Assert.assertEquals("post frank", post);
    }

}

