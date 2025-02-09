Feature: Sample test to demo Cucumber
#  Scenario: Positive number of cucumber remaining
 #   Given I have 30 cucumbers
  #  When I eat 5 cucumbers
   # Then I have 25 cucumbers remaining

  Scenario Outline: Number of cucumber remaining
    Given I have <start> cucumbers
    When I eat <eaten> cucumbers
    Then I have <remaining> cucumbers remaining
    And I am 'happy'
    Examples:
      | start | eaten | remaining |
      | 20    | 5     | 15        |
      | 5     | 5     | 0         |
      | 3     | 5     | -2        |

