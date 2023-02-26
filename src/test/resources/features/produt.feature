Feature: search a product feature

  Scenario: Verify that the user can able to search a product
    Given the user navigates to the home page
    When the user enter the product name
    Then the product results should be displayed


  Scenario: Verify that the selected product is displayed on the product detail page


    Given the user is on the Amazon homepage
    When the user has searched for a product
#    And the user selects a product from the search results
    Then the user should see the product detail page

  Scenario: verify that user display product
    Given the user back to Amazon homepage
    When the user search a product
    Then the user see particular product detail page
    And the user again back to another url1

  Scenario: verify that no results found
#    When the user goes back to the homepage
     And  the user again back to another url2

  #    Examples:
#      | url                      |
#      | wrong_url_1              |
#      | wrong_url_2              |
#      | https://example.com/cart |
#      | https://example.com/item |
#      | ...                      |
#   @smoke
  Scenario Outline:  Check if the add to cart is accessible
    When the user goes back to the homepage
    Then the user enters "<url>"

    Examples:
      | url                      |
      | https://www.apple.com/in/|
#   | https://nxfdxjhgffsdvvmfzm.com/           |
#      | https://example.com/cart |
#      | https://example.com/item |
#      | ...                      |

#    Then the user gets no results page

#  Then the product detail page should display all the relevant information such as price, description,images, etc.

#Feature: Product Filters
#  Scenario 2: Test the functionality of the filters (e.g. price range, product type, etc.)
#    Then the user is on the Amazon homepage
#    And the user has searched for a product
#    When the user applies filters like price range, product type, etc.
#    Then the user should see the filtered results

#Feature:  Product Filter Results
#  Scenario 3: Verify that the filtered results are displayed correctly
#    Then the user is on the Amazon homepage
#    And the user has searched for a product
#    When the user applies filters like price range, product type, etc.