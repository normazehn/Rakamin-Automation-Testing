Feature: Login Page sauce demo

  @Regression @Positive
  Scenario: User login using true username and password
    Given user in login page sauce demo
    When user input username : standard_user
    And user input password : secret_sauce
    And user tap Login button
    Then user successfully login

  @Regression @Negative
  Scenario: User login using true username and wrong password
    Given user in login page sauce demo
    Then user input username : standard_user
    And user input password : try-and-error
    Then user tap Login button