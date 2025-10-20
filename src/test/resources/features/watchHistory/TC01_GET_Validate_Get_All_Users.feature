@get
  Feature: Retrieve all users from the Watch History API

    Background:
    # Base URL and Headers are configured

    Scenario: Validate that GET /users returns all users successfully
      Given the userId = "3"
      When GET request is sent
      Then response status should be 200
      Then the response should contain first name "Emma"
