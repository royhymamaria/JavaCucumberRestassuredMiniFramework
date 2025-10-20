  @Ignore
  Feature: POST - Validation of New User Creation feature

    Background:
    # Base URL and Headers are configured

    Scenario Outline: Validate that POST user creates new user record successfully
      Given the user with name as "<name>" and job as "<job>"
      When POST request is sent
      Then response status should be 201 OK
      Then the response should match the "<name>" and "<job>"

      Examples:
        | name        | job      |
        | Rose Maria  | Teacher  |
#        | Daniel John | Engineer |
