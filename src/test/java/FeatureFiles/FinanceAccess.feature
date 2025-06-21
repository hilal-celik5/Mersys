@LoginRequired
Feature: Finance Access  Functionality

  Scenario: Access finance page as a logged-in user
    Given the user is logged in
    And the user has finance access permissions
    When the user navigates to the Finance page