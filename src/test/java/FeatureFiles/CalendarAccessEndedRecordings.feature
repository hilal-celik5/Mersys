Feature: Calendar Access Ended Recordings

  Scenario: User views ended recordings on the calendar
    Given User is on the calendar page
    And There are past courses with recording access ended
    When User opens the calendar and selects a past date
    Then User should see a label or message indicating access to recordings has ended

  Scenario: User tries to play ended recording
    Given User is on the calendar and selects a past course with ended access
    When User clicks on the play button for the recording
    Then User should see a warning that access has ended and cannot play the recording