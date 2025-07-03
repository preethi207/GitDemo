
@tag
Feature: Error Validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce page
    When I logged in with username <username> and password <password>
    Then "Incorrect email or password." message is dislayed

    Examples: 
      | username            |     password      | productName        |
      | preity207@gmail.com |     Welco1        |   ZARA COAT 3      |