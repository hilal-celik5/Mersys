@LoginRequired
Feature: Calendar Weekly View

  Scenario: Display weekly calendar view
    Given User is on the calendar page
    When User switches to weekly view
    Then Calendar should show 7 days horizontally with all scheduled sessions

  Scenario: User views details of a day in weekly view
    Given User is in weekly calendar view
    When User clicks on a specific day
    Then System should expand and show details of the classes scheduled for that day