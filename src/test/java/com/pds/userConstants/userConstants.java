package com.pds.userConstants;

import io.restassured.specification.RequestSpecification;

public class userConstants {

    //    Storing URLS
    public static final String GET_USERS_BASEURI = "https://reqres.in";
    public static final String GET_USERS_BASEPATH = "/api/users";
    public static final String POST_USERS_BASEURI = "https://jsonplaceholder.typicode.com";
    public static final String POST_USERS_BASEPATH = "/posts";

    public static RequestSpecification REQUEST_CONFIGS_GET;
    public static RequestSpecification REQUEST_CONFIGS_POST;
}