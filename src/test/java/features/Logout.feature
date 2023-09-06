@PETTSK
Feature: test logout scenario
  Scenario: Logout from pet store
    Given I logged out
    Then I should got valid status code