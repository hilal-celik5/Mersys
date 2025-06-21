Feature: Login Functionality

  Scenario: Login with valid username and password
    Given Navigate to login page
    And Enter valid username and password
    Then User should login successfully

  Scenario: Login with invalid username or password
    Given Navigate to login page
    And Enter invalid username and password
    When Click login button
    Then User should display error message