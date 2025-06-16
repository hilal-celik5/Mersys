@LoginRequired
Feature: Messaging Menu Functionality

  Scenario: Messaging submenu options are visible and clickable
    When The user clicks on the Hamburger Menu and hovers over the Messaging link
    Then the following submenu items should be visible and clickable:
      | Send Message |
      | Inbox        |
      | Outbox       |
      | Trash        |