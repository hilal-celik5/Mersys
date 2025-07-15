@LoginRequired
Feature: Grading View

  Scenario: View Course Grades
    Given the student navigates to the grading page
    Then the grades table should be displayed