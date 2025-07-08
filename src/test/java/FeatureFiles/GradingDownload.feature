@LoginRequired
Feature: Download notes as PDF

  Scenario Outline: PDF download for <section>
    When student opens "Grading"
    And student clicks the "<section>" tab
    And student clicks the "Print" icon
    Then a PDF viewer tab should open
    When student clicks the "Download" button
    Then the PDF file should be saved to the default download folder

    Examples:
      | section             |
      | Course Grade        |
      | Student Transcript  |