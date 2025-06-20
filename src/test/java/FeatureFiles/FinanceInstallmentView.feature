@LoginRequired
Feature: Finance installment view
  Scenario: Checking the Installment schedule
    Given Click on the Hamburger Icon
    And Navigate to Finance page
    When Click on the Fee Balance Detail button
    Then Installment schedule should be visible