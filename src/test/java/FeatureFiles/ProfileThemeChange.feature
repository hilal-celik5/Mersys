@LoginRequired
Feature: Profile Theme Change

  Scenario: Student successfully changes the theme
    Given the student navigates to the profile settings page
    When the student changes the theme
    Then the student should see a 'Success' message