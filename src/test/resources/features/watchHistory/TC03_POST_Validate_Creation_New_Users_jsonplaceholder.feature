@post
  Feature: POST - Validation of New User Creation feature

    Background:
    # Base URL and Headers are configured

    Scenario Outline: Validate that POST user creates new user record successfully
      Given the user with title "<title>", body "<body>" and userId as <userId>
      When POST request is sent
      Then response status should be 201 OK
      Then the response should match the "<title>" , "<body>" and <userId>

      Examples:
        | title      | body    | userId |
        | Rose Maria | Teacher | 1      |
        | Petal      | Doctor  | 2      |

