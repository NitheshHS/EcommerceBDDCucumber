Feature: Login Feature

Background: 
Given As a user I will launch browser
And Enter the url
And click on myAccount

@RegressionTest
Scenario: As a valid user I want to login to the application by entering username and password

When login page is dispalyed I will enter username and password
And Click on login
Then I will verify the username is present or not
And Signout from the application

@RegressionTest 
Scenario: As a user if I enter valid username and invalid password and click login page should throw an error

When login page is displayed I will enter valid username "nitheshdemo@gmail.com" and enter invalid password "nithesh123"
And Click on login
Then verify that error message is displaying or not
And close the browser