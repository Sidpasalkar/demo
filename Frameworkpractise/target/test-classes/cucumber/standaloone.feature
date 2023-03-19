
@tag
Feature: Book a Order
  I want to use this template for my feature file

  Background:
  Given Landing on Ecommerce page.

  @tag2
  Scenario Outline: Positive test of purchasing order
    Given Username <name> and password <password>
    When Adding a product <productname>
    And Checkout <productname> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed or not

    Examples: 
      | name          | password       | productname     |
      | sid@gmail.com |  Siddhesh@1998 | ADIDAS ORIGINAL |
      
