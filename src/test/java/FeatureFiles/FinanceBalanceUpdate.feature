@LoginRequired
Feature: Finance balance update

  Scenario: Checking the updated balance
    Given Click on the Hamburger Icon
    And Navigate to Finance page
    When Click on the stripe
    Then Student should be able to see updated balance