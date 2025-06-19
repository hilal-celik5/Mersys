Feature: Assignment Quick Actions

  Scenario: User marks an assignment as completed
    Given User is on the assignment list page
    When User clicks the quick action "Mark as Completed" for "Week 2 Reading"
    Then The assignment should be marked as completed and visually updated

  Scenario: User deletes an assignment from the list
    Given User sees the assignment "Old Draft" in the assignment list
    When User clicks the quick action "Delete" next to that assignment
    Then A confirmation prompt appears
    And After confirmation, the assignment is removed from the list

  Scenario: User uses quick action to open assignment details
    Given User is on the assignment list page
    When User clicks "View Details" quick action for an assignment
    Then System should open the assignment detail page