#Date
#Description

Feature: feature to test Login functionality

  Scenario: check login is successful with valid credentials

    Given user is on Login page
    When user enter username and password
    And click on Login button
    Then user is navigated to Home page

#    Scenario Outline: check login is successful with valid credentials
#
#      Given user is on Login page
#      When user enter <username> and <password>
#      And click on Login button
#      Then user is navigated to Home page
#
#      Examples:
#      | username | password |
#      | user1 | pass1      |
#      | user2 | pass2      |