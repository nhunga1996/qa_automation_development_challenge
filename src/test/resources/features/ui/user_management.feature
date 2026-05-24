@ui
Feature: User Management
  language: en

  Background:
    Given the user is logged into the OrangeHRM system
    And an employee exists for user creation
    And the user is on the User Management page

  Scenario: Successfully create a new system user
    When the user creates a new user with default information
    And the user searches for the newly created user by username
    Then the user should be found in the search results