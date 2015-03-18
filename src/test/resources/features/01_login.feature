Feature: Login to Test website

  Scenario: Login with valid credentials

    Given I want to access to my account
    When I enter my username Carledriss
    And I enter my password P@ssw0rd
    And I click submit button
    Then I should be able to login website Carledriss