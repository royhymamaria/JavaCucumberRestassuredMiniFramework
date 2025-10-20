package com.pds.stepdefinitions;

import com.pds.userConstants.userConstants;
import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class Hooks {

    @Before
    public void beforeScenario() {

        // Set default GET headers
        Map<String, String> headersGet = new HashMap<>();
        headersGet.put("Content-Type","application/json");
        headersGet.put("Accept","application/json");
        headersGet.put("User-Agent", "insomnia/11.6.1");
        headersGet.put("Accept-Encoding","gzip");
        headersGet.put("x-api-key","reqres-free-v1");

        // Set default POST headers
        Map<String, String> headersPost = new HashMap<>();
        headersPost.put("Content-Type","application/json");
        headersPost.put("Accept","application/json");
        headersPost.put("User-Agent", "insomnia/11.6.1");
        headersPost.put("Accept-Encoding","gzip");

        // Build a default request specification for GET
        userConstants.REQUEST_CONFIGS_GET = new RequestSpecBuilder()
                .setBaseUri(userConstants.GET_USERS_BASEURI)
                .setBasePath(userConstants.GET_USERS_BASEPATH)
                .addHeaders(headersGet)
                .build();


        // Build a default request specification for POST
        userConstants.REQUEST_CONFIGS_POST = new RequestSpecBuilder()
                .setBaseUri(userConstants.POST_USERS_BASEURI)
                .setBasePath(userConstants.POST_USERS_BASEPATH)
                .addHeaders(headersPost)
                .build();

        // ✅ Print all headers and confirmation
        System.out.println("ℹ\uFE0F Info: Global setup done - Base URL & Headers configured");
    }


}
