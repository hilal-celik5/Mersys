@LoginRequired
Feature: Top Navigation Functionality

  Scenario Outline: User clicks each top navigation item and verifies correct action
    When The user clicks on the "<menuItem>" button in the top navigation
    Then The "<menuItem>" page or panel should be displayed correctly

    Examples:
      | menuItem       |
      | courses        |
      | calendar       |
      | attendance     |
      | assignments    |
      | grading        |
      | hamburger menu |
      | announcements  |
      | messages       |
      | profile        |