@post
  Feature: POST - Validation of New User Creation feature

    Scenario Outline: Validate that POST user creates new user record successfully
      Given the user with title "<title>" and body "<body>"
      When POST request is sent
      Then response status should be 201 OK
      Then the response should match the "<title>" and "<body>"

      Examples:
        | title      | body    |
        | Rose Maria | Teacher | 
        | Petal      | Doctor  |

