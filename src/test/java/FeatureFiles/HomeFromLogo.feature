@LoginRequired
Feature: Navigation to Course Home Page via Logo

  Scenario: The user should be redirected to the course home page when clicking the logo
    When The user clicks on the company logo
    Then The user should be redirected to the Techno Study homepage