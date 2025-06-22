@LoginRequired
Feature: Messaging Restore Delete  Functionality

  Scenario:I should be able to restore or permanently delete trashed messages.
    Given Click on Trash under the Messages section from the Hamburger Menu.
    And Delete one of the messages you moved to the Trash.
    Then Get the confirmation message after deleting it.