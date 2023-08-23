Feature: Checkout Feature

  Scenario: Successful checkout flow
    Given I am logged in username "standard_user" and password "secret_sauce" on the saucedemo website
    And I am on the products page
    When I click on the "Add to cart" button for the item "Sauce Labs Backpack"
    Then Navigate to Cart and Verfy "Sauce Labs Backpack" item is present
    And Click on Checkout button
    And Enter the First Name as "Tanush" Last Name as "S" and postal code as "560001"
    And Click on Contiune button and Finish Button
    Then Verify user should see "Thank you for your order!" text
    And Click on Back Home button
    Then I should be on the saucedemo products page

  Scenario Outline: Checkout form with String data
    Given I am logged in username "standard_user" and password "secret_sauce" on the saucedemo website
    And I am on the products page
    When I click on the "Add to cart" button for the item "Sauce Labs Backpack"
    Then Navigate to Cart and Verfy "Sauce Labs Backpack" item is present
    And Click on Checkout button
    And Enter the user "<firstName>" "<lastName>" "<pin>"
    And Click on Contiune button and Finish Button
    Then Verify user should see "Thank you for your order!" text
    And Click on Back Home button
    Then I should be on the saucedemo products page
    Examples:
      | firstName      | lastName     | pin            |
      | Tanush         | s            | SDFG           |
      | 12345          | 9876         | 560001         |
      | !@#$%          | (*&^%)       | @#$%^          |
      | Tanush12345    | s1234        | SD560001       |
      | Tanush@#$      | s$%^         | dfghj*&^%      |
      | Tanush%^&*6543 | s(*&#$%^8765 | kjhg^&*(560001 |
      | 23456(*&^      | 8765#$%      | (*&^%560001    |


  Scenario: Successfully adding a single item to the cart for Add Cart Button functionality
    Given I am logged in username "standard_user" and password "secret_sauce" on the saucedemo website
    And I am on the products page
    When I click on the "Add to cart" button for the item "Sauce Labs Backpack"
    And the cart icon should display the updated number of items should be '1'
    Then Navigate to Cart and Verfy "Sauce Labs Backpack" item is present


  Scenario: Trying to Remove the Item from the Cart Remove Button functionality
    Given I am logged in username "standard_user" and password "secret_sauce" on the saucedemo website
    And I have already added the item "Sauce Labs Backpack" to the cart
    Then Verify that Remove button is displayed and Click on Remove Button
    And Navigate to Cart and Verfy "Sauce Labs Backpack" item is not present

  Scenario: Trying to add an item after removing it from the cart
    Given I am logged in username "standard_user" and password "secret_sauce" on the saucedemo website
    And I click on the "Add to cart" button for the item "Sauce Labs Backpack"
    When Verify that Remove button is displayed and Click on Remove Button
    And I go back to the products page
    And Try to add the same product "Sauce Labs Backpack" to the cart
    And the cart icon should display the updated number of items should be '1'
    Then Navigate to Cart and Verfy "Sauce Labs Backpack" item is present
