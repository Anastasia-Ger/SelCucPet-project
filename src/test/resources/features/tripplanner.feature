Feature: Trip Planner
  Scenario: Plan a trip from point A to point B
    Given I open BudapestGo website
    And I accepted privacy policy
    And Page language is set to English

    When I fill From field with 'Keleti pályaudvar'
    And I fill To field with 'Aradi utca (Oktogon M)'
    And I click on Plan button

    Then The trip is planned
