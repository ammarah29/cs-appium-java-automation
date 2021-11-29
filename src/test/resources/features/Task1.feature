@web
Feature: Cookies
  As a ClearScore customer
  I want to manage my ClearScore cookie settings
  So that the appropriate cookies are set

  Scenario: Cookies notification is displayed
    Given I navigate to the ClearScore home page
    Then I expect the cookie notification is displayed

  Scenario: Cookies notification can be dismissed
    Given I navigate to the ClearScore home page
    When I dismiss the cookie notification
    Then I expect the cookie notification is not displayed

  Scenario: Cookies notification does not reappear
    Given I navigate to the ClearScore home page
    When I dismiss the cookie notification
    And I refresh the page
    Then I expect the cookie notification is not displayed

  Scenario: ClearScore cookies are set
    Given I navigate to the ClearScore home page
    When I dismiss the cookie notification
    Then I expect the appropriate cookies are set