@SupportPageTests @UISpecTests
Feature: Support Page Functionalities Verification
  As a user, I want to check options available on Support Page

  Background:
    Given User navigates to the Home Page

  @OneTimeAndMonthlySupport
  Scenario: Verify if user is able to check if one time and monthly options are available
    Given User clicks on Support ReqRes Option
    When User reaches Support Page and check for options
    Then One Time and Monthly options should be available
    And User closes the browser

  @CheckForUpgradeOption
  Scenario: Verify if Upgrade option is available
    Given User checks for Upgrade Options
    When User clicks on Upgrade
    Then Upgrade details should be provided
    And User closes the browser