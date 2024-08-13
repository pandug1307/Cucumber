#Date
#Description

Feature: feature to test Google search functionality

  Scenario: check Google search

    Given user is on chrome browser
    And open google site
    When user search any keyword
    And hits enter
    Then verify the search result