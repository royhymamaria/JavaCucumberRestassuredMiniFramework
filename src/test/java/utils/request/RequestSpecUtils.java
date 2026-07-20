package utils.request;

import constants.userConstants;
import io.restassured.builder.RequestSpecBuilder;

public class RequestSpecUtils {

    public static void getRequestSpecForGetMethod(){
        // Build a default request specification for GET
        userConstants.REQUEST_CONFIGS_GET = new RequestSpecBuilder()
                .setBaseUri(userConstants.GET_USERS_BASEURI)
                .setBasePath(userConstants.GET_USERS_BASEPATH)
                .addHeaders(HeaderUtils.getDefaultGetHeaders())
                .build();
    }

    public static void getRequestSpecForPostMethod(){
        // Build a default request specification for POST
        userConstants.REQUEST_CONFIGS_POST = new RequestSpecBuilder()
                .setBaseUri(userConstants.POST_USERS_BASEURI)
                .setBasePath(userConstants.POST_USERS_BASEPATH)
                .addHeaders(HeaderUtils.getDefaultPostHeaders())
                .build();
    }

}
