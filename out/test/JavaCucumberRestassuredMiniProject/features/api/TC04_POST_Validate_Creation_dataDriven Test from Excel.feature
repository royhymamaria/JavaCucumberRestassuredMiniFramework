@post
  Feature: Create User via POST API

    As a consumer of the User Management API
    I want to create new users using external test data
    So that the API can be validated with multiple data combinations

    Background:
    # Base URL and Headers are configured

    Scenario: Validate Create users using Excel test data
      Given the user payload is passed from "testData/testData.xlsx" sheet "Sheet1"
      When POST request is sent
      Then response status should be 201 OK
#      Then the response should match the "<title>" and "<body>"

