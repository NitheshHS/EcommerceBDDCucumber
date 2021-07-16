Feature: Search Course feature

@RegressionTest @End2End
  Scenario Outline: As a user I want search for multiple course and get the title of the course
    Given I want launch the "chrome" browser
    And Enter the url "http://practice.automationtesting.in/"
    When home page is displayed I want search for "<course>"
    And get count of each course and title of course
    Then verify in the search result "<course>" name is there or not
    And close the browser

    Examples: 
      | course      |
      | html        |
      | android     |
      | Java script |

  @SmokeTest
  Scenario: As a valid after login fill all the account details
    Given I want launch the "firefox" browser
    And Enter the url "http://practice.automationtesting.in/"
    And go to my account tab
    When login page is displayed enter the username "nitheshdemo@gmail.com" and password "Nithesh@040598"
    And click on login
    And click on account details
    And In account details page fill first name, lastname, current password, new password and confirm password
      | firstName | Lastname | Current password | New password   | confirm password |
      | Nithesh   | H S      | Nithesh@040598   | Nithesh@040598 | Nithesh@040598   |
    And click on save changes
    Then verify the successful message displayed or not "Account details changed successfully."
