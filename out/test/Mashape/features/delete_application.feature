Feature: Delete Applications from Mashape website

  Scenario: Delete an Application from Dashboard

    Given I want to delete application apptest1
    When I navigate to general settings for delete
    And I click delete button
    And I confirm deletion of apptest1
    Then I should be able to delete the application