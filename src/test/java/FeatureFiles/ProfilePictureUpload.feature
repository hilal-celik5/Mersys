@LoginRequired
Feature: Upload and change profile photo

  Scenario: A valid .jpg file is uploaded
    When student opens "Profile > Settings"
    And student clicks the profile image
    And student uploads "pngimg.com - white_dove_PNG39.png" smaller than 5 MB
    Then success toast appears