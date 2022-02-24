
Feature: Making payment operations

  Background:
    Given the user is logged in

  Scenario: user is making a payment operation
    And  Account Activity page has "Zero - Pay Bills" as title
    When user completes a successful pay operation
    Then A successful message should be displayed should be displayed
    When user tries to make a payment without entering amount or date
    Then An error message should be displayed

