Feature: As a Pastbook User I should be able to sign up to the application by providing email and I should be able to reset the password

  Background:
    Given I am in Pastbook Home Page

  Scenario Outline: As a user I should be able to Sign up and reset Password
    When I click on sign in menu
    And I navigated to sign in popup screen
    And I click on use email option
    And I enter the <email> to the email text box
    And I click on submit button
    And I get re-directed to Home Page as a Logged in User
    And I navigated to profile
    And I reset the password to <password>
    Then I click on save password button

    Examples:
    |email|password|
    |testpastbook+14@testemail.com|123@com|