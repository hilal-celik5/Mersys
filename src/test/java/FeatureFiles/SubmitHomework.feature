@LoginRequired
Feature: Submit Homework Functionality

  Scenario: Student uploads assignment file and sees success message
    When Click on the assignments link
    Then Submit icon should be visible on each assignment row
    When Clicks on an assignment and uploads a file
    Then Success message should be displayed
    When The student clicks the New Submission button on an assignment detail page
    Then A text editor should appear as a popup