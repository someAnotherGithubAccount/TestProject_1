Feature: Dashboard

  Scenario Outline:
    Given I am on Dashboard page
    When I click on category "<category>"
    Then I will be redirected to page "<page>"

    Examples:
      | category | page    |
      | Woman    | woman   |
      | Dresses  | dresses |

  Scenario:
    Given I am on Dashboard page
    When I open Women category
    Then I should see Tops category
    And I should see Dresses category