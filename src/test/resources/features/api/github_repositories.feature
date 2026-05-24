@api
Feature: GitHub Repository Analysis

  Scenario: Analyze SeleniumHQ repositories
    When user retrieves all repositories from SeleniumHQ organization
    Then total open issues should be calculated
    And highest starred repository should be identified