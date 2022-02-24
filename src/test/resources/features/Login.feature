Feature: only authorized users should be able to login

  Background:
    Given the user is on the login page


  Scenario: login with valid credentials
    When User enters valid "username" and "password" credentials
    Then "Account Summary" page should be displayed

  @wip
  Scenario Outline: login with invalid credentials<usernameInput>
    When User enters "<usernameInput>" or "<passwordInput>" credentials
    Then "Login and/or password are wrong." should be displayed
    Examples:
      | usernameInput | passwordInput |
      | username      | wrong         |
      | wrong         | password      |
      | username      |               |
      |               | password      |
      |               |               |