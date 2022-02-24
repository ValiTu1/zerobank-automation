
Feature: Account types

  Scenario: all account types are displayed
    Given the user is on Account Summary page
    And Account summary has the following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    Then Credit Accounts table must have the following columns
      | Account     |
      | Credit Card |
      | Balance     |