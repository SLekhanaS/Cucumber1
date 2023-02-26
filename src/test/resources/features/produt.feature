Feature: search a product feature
  Scenario: Verify that the user can able to search a product
    Given the user navigates to the home page
    When the user enter the product name
    Then the product results should be displayed

  Scenario: Verify that the selected product is displayed on the product detail page
    Given the user is on the Amazon homepage
    When the user has searched for a product
    Then the user should see the product detail page

  Scenario: verify that user display product
    Given the user back to Amazon homepage
    When the user search a product
    Then the user see particular product detail page
    And the user again back to another url1

  Scenario: verify that no results found
     And  the user again back to another url2

  Scenario Outline:  Check if the add to cart is accessible
    When the user goes back to the homepage
    Then the user enters "<url>"

    Examples:
      | url                      |
      | https://www.apple.com/in/|

