Feature: Assignment Start Discussion

  Scenario: User starts a new discussion under an assignment
    Given User is on the details page of "Project Report"
    When User clicks "Start Discussion" and writes a message
    Then The discussion should appear under the Discussions tab of that assignment

  Scenario: User replies to an existing discussion
    Given There is an existing discussion under "Research Summary"
    When User clicks "Reply" and submits a response
    Then The reply should be displayed under the original discussion thread

  Scenario: User cannot start a discussion on a closed assignment
    Given Assignment "Final Essay" is marked as closed
    When User clicks "Start Discussion"
    Then System should display a message: "Discussions are disabled for this assignment"