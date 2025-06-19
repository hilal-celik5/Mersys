Feature: Assignment Search and Sort

  Scenario: User searches for an assignment by keyword
    Given User is on the Assignments page
    When User types "essay" into the search bar
    Then All assignments with titles containing "essay" should be listed

  Scenario: User sorts assignments by due date ascending
    Given User is on the Assignments page
    When User selects "Sort by Due Date: Earliest First"
    Then Assignments should be displayed in order from nearest to farthest due date

  Scenario: User sorts assignments by status
    Given User is on the Assignments page
    When User selects "Sort by Status: Incomplete First"
    Then Incomplete assignments should appear before completed ones