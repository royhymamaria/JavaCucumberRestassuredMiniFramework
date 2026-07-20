@get
  Feature: Retrieve all users for a given userId

    Scenario: Validate that GET returns all users successfully for a given userId
      Given the userId = "3"
      When GET request is sent
      Then response status should be 200
      And the response should contain first name "Emma"
      And the response match with DB data
