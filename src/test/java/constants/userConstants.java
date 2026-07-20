package constants;

import config.ConfigLoader;
import io.restassured.specification.RequestSpecification;

public class userConstants {

    //    Storing URLS
    public static final String GET_USERS_BASEURI = ConfigLoader.getConfig("base.uri.get");
    public static final String GET_USERS_BASEPATH = ConfigLoader.getConfig("base.path.get");
    public static final String POST_USERS_BASEURI = ConfigLoader.getConfig("base.uri.post");
    public static final String POST_USERS_BASEPATH = ConfigLoader.getConfig("base.path.post");

    public static RequestSpecification REQUEST_CONFIGS_GET;
    public static RequestSpecification REQUEST_CONFIGS_POST;
}