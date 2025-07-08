@LoginRequired
Feature: Grading page links


  Scenario: Verify the three tabs on the Grading page
    When student opens "Grading"
    Then the "Course Grade", "Student Transcript" and "Transcript By Subject" tabs should be visible and clickable