@LoginRequired
Feature: Choosing a theme

  Scenario: Display theme menu
    When student opens "Profile > Settings"
    Then the Default Theme dropdown is visible
    When student clicks the Default Theme dropdown
    Then there should be at least 3 theme options: purple, dark purple, indigo

  Scenario Outline: Select and save the theme
    When student opens "Profile > Settings"
    And student selects "<theme>" from the Default Theme dropdown
    Then the page DOM attribute "data-theme" should equal "<attr>"
    When student clicks the Save button
    Then success toast appears

    Examples:
      | theme        | attr        |
      | purple       | purple      |
      | dark purple  | dark-purple |
      | indigo       | indigo      |