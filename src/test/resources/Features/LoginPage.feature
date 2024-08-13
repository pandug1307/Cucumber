@LoginPage

  Feature: Login to Amazon application

    Background:
    Given user is on Amazon page "https://www.amazon.in/"

    @ValidCredentials
    Scenario: Login with valid credentials

      When user enters username as "7043838900" and password as "Hello@123"
      Then user should be able to login successfully and Home page is open
#      When hits SignOut button
#      Then back to Login page

    @InvalidCredentials
    Scenario Outline: Login with invalid credentials

      When user enters username as "<username>" and password as "<password>"
      Then user should be able to see the error message "<errorMessage>"

      Examples:
        | username | password | errorMessage |
        | 7043838901 | Hello@123 | Create Account |