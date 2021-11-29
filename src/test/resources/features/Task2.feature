@mobile
Feature: Validate Log In Details
  As a ClearScore customer
  I want to login to my account
  So that I can access my home screen

    # Last two steps are not automated as I'm unable to see login page due to connection error
  Scenario: Incorrect password on log in
    Given I am a ClearScore customer
    When I try to log in with email "test@test.com" and password "abc123"
    Then I am shown an invalid login alert