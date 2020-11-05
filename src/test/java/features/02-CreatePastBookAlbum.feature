Feature: As a User I should be able to Create a PastBook

  Background:
    Given I am in Pastbook Home Page

  Scenario Outline: As a Logged in User I should be able to create a PastBook
    When I click on sign in menu
    And I navigated to sign in popup screen
    And I click on use email option
    And I enter the <email> to the email text box
    And I click on submit button
    And I enter the <password> on the password text box
    And I click on submit button
    And I get re-directed to Home Page as a Logged in User
    And I click on create menu option
    And I get navigated to create Past Book Page
    And I close pop-up advertisement
    And I enter <title> into Title text field
    And I click on option link text
    And I click on Add Cover Button
    And I add a cover photo <img>
    Then I click on create your Pastbook button
    When I click on upload picture
    And I add album photo <img1> and click on upload
    Then I click on continue button
    And I logout from pastbook application

    Examples:
    |email|password|title|img|img1|
    |testpastbook+14@testemail.com|123@com|My Test Past Book|7.jpg|3.jpg|

