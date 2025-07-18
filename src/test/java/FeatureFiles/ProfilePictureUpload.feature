@LoginRequired
Feature: Profile Picture Upload

  Scenario: Student successfully uploads a profile picture
    Given the student navigates to the profile settings page
    When the student uploads a profile picture
    Then the student should see a "Success" message