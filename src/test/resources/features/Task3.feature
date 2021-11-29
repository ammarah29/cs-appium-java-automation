@mobile
Feature: Register Log In Details
  As a new ClearScore customer
  I want to register for a new account
  So that I can sign up to ClearScore

  Scenario: Email address is required to sign up
    Given I am not a ClearScore customer
    When I enter email address ""
    And I tap on the continue button
    Then I expect the continue button is not enabled

  Scenario: Valid email address must be provided to sign up
    Given I am not a ClearScore customer
    When I enter email address "abc123"
    Then I expect an email validation error is displayed

  # Last step is not automated as it's unable to see registration page due to connection error
  Scenario: Valid user email address is provided
    Given I am not a ClearScore customer
    When I enter email address "test@test.com"
    And I tap on the continue button
    Then I am taken to step one of registration

  Scenario: Navigate back to the landing screen from registration
    Given I am not a ClearScore customer
    When I tap on the back button
    Then I go back to the landing page