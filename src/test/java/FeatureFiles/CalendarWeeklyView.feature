@LoginRequired
Feature: Calendar Access Ended Recording

  Scenario: Weekly View
    Given Student clicks hamburger menu to reach lectures weekly view
    When Student chooses correct date and clicks
    Then Students should be able to see lectures