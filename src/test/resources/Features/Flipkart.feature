#Author: Ezhil
Feature: Flipkart App Automation

  @mobilesearch
  Scenario Outline: Add Redmi mobile into Flipkart cart
    Given Enter credentials for flipkart app using "<uname>","<pwd>"
    When Search mobile in the search field  "<mobilename>"
    And Product name and price of the product store should be stored in the ArrayList
    Then Print the lowest price product in the console
    Then Add to cart a mobile second-lowest product.

    Examples: 
      | mobilename | uname                | pwd        |
      | Redmi      | thamizhsvk@gmail.com | 9786615277 |
