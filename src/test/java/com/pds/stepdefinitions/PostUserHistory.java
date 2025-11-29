package com.pds.stepdefinitions;

import com.pds.payLoads.UsageHistoryPayloads;
import com.pds.userConstants.userConstants;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PostUserHistory {

    private Response response;
    private Object requestPaylod;

    @Given("the user with title {string}, body {string} and userId as {int}")
    public void the_user_details_is_sent(String title,String body,int userId) throws JsonProcessingException{
        requestPaylod = UsageHistoryPayloads.validPayloadStatic(title,body,userId);
//        System.out.println("ℹ\uFE0F Info : Payload is: " + requestPaylod);
    }

    @When("POST request is sent")
    public void post_request_is_sent() {

//        System.out.println("🔗After Final URL: " + RestAssured.baseURI + RestAssured.basePath);
        response = given()
                .spec(userConstants.REQUEST_CONFIGS_POST)
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
                .body(requestPaylod)
                .when()
                .post("/");
//        System.out.println(requestSpecs.getHeaders());
    }

    @Then("response status should be {int} OK")
    public void response_status_should_be_201(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response should match the {string} , {string} and {int}")
    public void the_response_should_match_the_name_and_job_given(String title,String body,int userId) {

        try {
            assertThat(response.jsonPath().getString("title"), equalTo(title));
            assertThat(response.jsonPath().getString("body"), equalTo(body));
            assertThat(response.jsonPath().getInt("userId"), equalTo(userId));
            System.out.println("✅ [PASS] All response fields matched successfully!");

        }catch (AssertionError e){
            System.err.println("❌ [FAIL] Response validation failed: " + e.getMessage());
            throw e; // Rethrow so Cucumber marks the test as failed
        }
        // ✅ Log full response details (fallback-friendly)
        System.out.println("\n================= 🔵 Response Details =================");
        try {
            response.then().log().all(); // Best way if using Rest Assured
        } catch (Exception ex) {
            // Fallback manual log if log().all() fails
            System.out.println("Status Code: " + response.getStatusCode());
            System.out.println("Headers: " + response.getHeaders());
            System.out.println("Body:\n" + response.getBody().asPrettyString());
        }
        System.out.println("========================================================\n");
    }

    }