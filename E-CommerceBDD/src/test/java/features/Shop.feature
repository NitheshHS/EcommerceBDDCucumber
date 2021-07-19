Feature: Shop feature

Background:
Given enter the URL "http://practice.automationtesting.in/"

  Scenario: 
    
    And click on Shop Menu
    When Shop page is displayed i will go on price slider
    And Adjust the slider 150 to 350
    And Click on filter button
    Then verify the product price between 150 to 350 or not
