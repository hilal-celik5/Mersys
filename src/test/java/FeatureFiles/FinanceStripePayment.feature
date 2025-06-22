@LoginRequired
Feature: Doing the Payment

  Scenario: Doing the payment using the stripe
    Given Click on the Hamburger Icon
    And Navigate to Finance page
    When Click on the stripe
    Then Student should be able to do payment