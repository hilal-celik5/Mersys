Feature: Calendar Block for Unstarted Course

  Scenario: Calendar shows upcoming course not started
    Given User is on the calendar page
    And There is a future course that has not started yet
    When User selects the course date on the calendar
    Then Calendar block should show “Course not started yet”

  Scenario: User clicks on an unstarted course
    Given Calendar displays a course that is not yet started
    When User tries to open its details or video
    Then User should see a message like “Course has not started yet”