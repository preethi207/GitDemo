
@tag
Feature: Purchase order from Ecommerce Website
  I want to use this template for my feature file


   Background:
   Given I landed on Ecommerce page

  @Regression
  Scenario Outline: Positive testcase for submitting the order
    Given I logged in with username <username> and password <password>
    When I add product <productName> in cart
    And checkout <productName> and submit the order 
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmationpage

    Examples: 
      | username            |     password      |   productName     |
      | preity207@gmail.com |     Welcome1      |   ZARA COAT 3     |
     
