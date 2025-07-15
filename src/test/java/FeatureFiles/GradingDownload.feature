@LoginRequired
Feature: Grading Download

  Scenario: Student downloads Course Grade PDF
    Given the student navigates to the grading page
    When the student clicks the print icon
    Then the PDF document should be displayed
    When the student clicks the download button
    Then  the download button should trigger a file download