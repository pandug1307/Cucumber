#Date
#Description

  Feature: feature to test Amazon SignIn page
    Scenario Outline: test Amazon site with valid username and password

      Given user is on Chrome browser
      And open Amazon site
      When user SingIn with <username> and <password>
      When navigated to the Home page
      And hits SignOut button
      Then back to SignIn page

      Examples:
        | username | password |
      | 7043838900 | Hello@123 |
      | 7043838900 | Hello@123 |