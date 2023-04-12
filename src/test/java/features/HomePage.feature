@HomePageTests @UISpecTests
Feature: Home Page Functionalities Verification
  As a user, I want to check specific operations on HomePage

  Background:
    Given User navigates to the Home Page

  @HomePageRequestsTypesAndEndPoints
  Scenario: Verify if user is able to check different requests types and endpoints
    Given User reaches the HomePage
    When User verifies different endpoints
    And User verifies different request types
    Then User checks the status code and closes the browser

  @SampleRequestAndResponse @RequestNotFound
  Scenario Outline: Selects and Verifies sample request and response
    Given User reaches the HomePage
    When User selects "<Endpoint>"
    Then The request should be "<RequestType>"
    And The response should be "<ResponseCode>"
    And User closes the browser

    Examples:
      | Endpoint              | RequestType   | ResponseCode |
      | SINGLE USER NOT FOUND | /api/users/23 | 404          |


  @SupportPageNavigationButton
  Scenario: Verifying if the page contains button to Support Page Navigation
    Given User reaches the HomePage
    When User clicks on Support Page Navigation Button
    Then User should be navigated to Support Page
    And User closes the browser