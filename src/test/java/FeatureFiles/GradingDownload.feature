@LoginRequired @US016
Feature: Notları PDF olarak indirme

  Bir öğrenci olarak, detaylı ders notlarımı (Course Grade) ve transkriptimi (Student Transcript)
  campus uygulamasını kullandığım cihaza indirebilmeliyim.

  Scenario Outline: <section> için PDF indirme
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