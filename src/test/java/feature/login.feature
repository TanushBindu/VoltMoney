Feature: Login functionality on saucedemo.com

  Scenario: Successful login with correct username and password
    Given I am on the saucedemo login page
    When I enter the username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should be on the saucedemo products page

  Scenario Outline: Failed login with incorrect password
    Given I am on the saucedemo login page
    When I enter the username "<username>" and password "<password>"
    And I click the login button
    Then I should see an error message "Epic sadface: Username and password do not match any user in this service"
    Examples:
      | username                | password           |
      | standard_user           | incorrect_password |
      | locked_out_user         | incorrect_password |
      | problem_user            | incorrect_password |
      | performance_glitch_user | incorrect_password |

  Scenario: Failed login with non-existing username
    Given I am on the saucedemo login page
    When I enter the username "non_existing_user" and password "secret_sauce"
    And I click the login button
    Then I should see an error message "Epic sadface: Username and password do not match any user in this service"

  Scenario: Failed login with empty username and password
    Given I am on the saucedemo login page
    When I enter the username "" and password ""
    And I click the login button
    Then I should see an error message "Epic sadface: Username is required"