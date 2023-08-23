Feature: Add to Cart Functionality

  Scenario: Successfully adding a single item to the cart
    Given I am logged in username "standard_user" and password "secret_sauce" on the saucedemo website
    And I am on the products page
    When I click on the "Add to cart" button for the item "Sauce Labs Backpack"
    And the cart icon should display the updated number of items should be '1'
    Then Navigate to Cart and Verfy "Sauce Labs Backpack" item is present


#  Scenario: Trying to add an item that is already in the cart
#    Given I am logged in on the saucedemo website
#    And I have already added the item "Sauce Labs Backpack" to the cart
#    When I try to click on the "Add to cart" button for the same item
#    Then I should see a message indicating that the item is already in the cart
#
#  Scenario: Trying to add an item after removing it from the cart
#    Given I am logged in on the saucedemo website
#    And I have added the item "Sauce Labs Backpack" to the cart
#    When I remove the item from the cart
#    And I go back to the products page
#    And I try to click on the "Add to cart" button for the same item
#    Then I should see a success message indicating that the item was added to the cart
#    And the cart icon should display the updated number of items