Feature: Login functionality

  Scenario: Successful login

    Given user launches browser
    When user opens login page
    And user enters username and password
    Then user should see dashboard