@LoginRequired
Feature: Atendance Excuse
  Scenario:Sending excuse message
    Given Navigate to Atendance page
    When Add an excuse message "Hello sir. I do not feel OK today."
    Then User should send excuse message
Scenario:Check if message sent or not
    Given Navigate to Atendance page
    When Click on the edit message button
    Then Excuse message "Hello sir. I do not feel OK today." should be send
