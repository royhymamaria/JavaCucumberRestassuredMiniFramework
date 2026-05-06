package com.pds.stepdefinitions;

import com.pds.userConstants.userConstants;
import com.pds.utils.DBUtils;
import com.pds.utils.TestUtils;
import io.cucumber.java.en.*;
import io.restassured.response.*;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class GetAllUserHistory {

    private Response response;
    private String userId;

    @Given("the userId = {string}")
    public void setUserDetails(String userId){
        this.userId =  userId;
    }

    @When("GET request is sent")
    public void getRequestIsSent(){
        response = given()
                .spec(userConstants.REQUEST_CONFIGS_GET)
                .filter((reqSpec, respSpec, ctx) -> {
                    // Print the URI
                    System.out.println("ℹ️ Info: Sending to URI: " + reqSpec.getURI());

                    // Print all headers
                    System.out.println("ℹ️ Info: Request Headers:");
                    reqSpec.getHeaders().asList()
                            .forEach(header -> System.out.println(header.getName() + ": " + header.getValue()));

                    // Proceed with request execution
                    return ctx.next(reqSpec, respSpec);
                })
                .when()
                .get(userId);

    }

    @Then("response status should be {int}")
    public void verifyStatusCode(int statusCode){
//        assertEquals(statusCode,response.getStatusCode());
        response.then().statusCode(statusCode);
        System.out.println("✅ Response status: " + response.getStatusCode());


    }

    @Then("the response should contain first name {string}")
    public void verifyResponseBody(String expectedFirstName){
        String actualFirstName = response.jsonPath().getString("data.first_name");
        assertEquals(expectedFirstName, actualFirstName);
//        assertThat(response.jsonPath().getString("name"), equalTo(name));
        System.out.println("✅ Response body:\n" + response.getBody().asPrettyString());
    }

    @And("the response match with DB data")
    public void verifyResponseBodyMatchWithDBData(){
        String actualFirstName = response.jsonPath().getString("data.first_name");
        String dbResult = TestUtils.getDBValue(
                "Emma"
        ).toString();

//        String dbFirstName = dbResult.get("first_name").toString();
        assertEquals(actualFirstName, dbResult);
        System.out.println("✅ DB Result\n" + dbResult);
        System.out.println("✅Result is Matched");
    }

}
