@LoginRequired
Feature: Calendar Access Ended Recording

  Scenario: Play Lecture Recording
    Given Student clicks hamburger menu to reach lecture recording
    When Student chooses correct date and clicks on the recording button
    Then Students should be able to watch recording