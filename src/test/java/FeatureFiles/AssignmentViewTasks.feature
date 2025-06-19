Feature: Assignment View Tasks

  Scenario: User views all tasks under a multi-part assignment
    Given User is on the assignment "Team Project"
    When User expands the task list
    Then All subtasks like "Outline", "Draft", and "Final Report" should be listed

  Scenario: User views task progress
    Given User is on the task list for "Team Project"
    When User checks progress indicators
    Then Each task should show its status as Not Started, In Progress, or Completed

  Scenario: User opens task details
    Given The assignment "Team Project" has multiple tasks
    When User clicks on the task "Final Report"
    Then System should display its description, due date, and submission status