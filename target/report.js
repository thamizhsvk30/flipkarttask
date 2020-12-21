$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Features/Flipkart.feature");
formatter.feature({
  "name": "Flipkart App Automation",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Add Redmi mobile into Flipkart cart",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@mobilesearch"
    }
  ]
});
formatter.step({
  "name": "Enter credentials for flipkart app using \"\u003cuname\u003e\",\"\u003cpwd\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "Search mobile in the search field  \"\u003cmobilename\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "Product name and price of the product store should be stored in the ArrayList",
  "keyword": "And "
});
formatter.step({
  "name": "Print the lowest price product in the console",
  "keyword": "Then "
});
formatter.step({
  "name": "Add to cart a mobile second-lowest product.",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "mobilename",
        "uname",
        "pwd"
      ]
    },
    {
      "cells": [
        "Redmi",
        "9003994682",
        "B@positive5"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Add Redmi mobile into Flipkart cart",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@mobilesearch"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Enter credentials for flipkart app using \"9003994682\",\"B@positive5\"",
  "keyword": "Given "
});
formatter.match({
  "location": "FlipkartStepDefinition.enter_credentials_for_flipkart_app_using(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Search mobile in the search field  \"Redmi\"",
  "keyword": "When "
});
formatter.match({
  "location": "FlipkartStepDefinition.search_mobile_in_the_search_field(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Product name and price of the product store should be stored in the ArrayList",
  "keyword": "And "
});
formatter.match({
  "location": "FlipkartStepDefinition.product_name_and_price_of_the_product_store_should_be_stored_in_the_ArrayList()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Print the lowest price product in the console",
  "keyword": "Then "
});
formatter.match({
  "location": "FlipkartStepDefinition.print_the_lowest_price_product_in_the_console()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Add to cart a mobile second-lowest product.",
  "keyword": "Then "
});
formatter.match({
  "location": "FlipkartStepDefinition.add_to_cart_a_mobile_second_lowest_product()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});