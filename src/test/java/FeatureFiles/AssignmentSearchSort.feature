@LoginRequired
Feature: Assignment Search and Sort

  Scenario: User sorts assignments by due date ascending
    Given User is on the Assignments page
    When User selects "Default View"
    Then Assignments should be displayed in order from nearest to farthest due date

  Scenario: User sorts assignments by status
    Given User is on the Assignments page
    When User selects "Default View"
    Then Incomplete assignments should appear before completed ones