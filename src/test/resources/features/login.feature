Feature: Login functionality

  Scenario Outline: Successful login

    Given user launches browser
    When user opens login page
    And user enters "<username>" and "<password>"
    Then user should see "<output>"

Examples:
    |username|password|output|
    |Admin|admin123|dashboard|
    |Admin1234|admin1234|error message|
    |Admin1234$|admin1234$|error message|