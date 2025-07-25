@LoginRequired
Feature:Assignment Quick Actions Functionality

  Scenario: Icons in a randomly selected assignment are clickable and redirect to the correct pages
    When Click on the assignments link
    And Selects a random assignment row and checks the visibility and clickable of action icons
    Then Clicks on the information icon and verifies redirection to the assignment info page