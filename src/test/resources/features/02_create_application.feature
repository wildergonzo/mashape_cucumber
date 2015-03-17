Feature: Create Applications from Mashape website

  Scenario: Create an Application from Dashboard

    Given Login as Carledriss P@ssw0rd
    When Create a new application My new App1 in Dashboard
    Then New App My new App1 should be displayed in Sidebar

  Scenario: Create an Application from Dropdown

    Given Login as Carledriss P@ssw0rd
    When Create a new application My new App2 in Dropdown
    Then New App My new App2 should be displayed in Dashboard