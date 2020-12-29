Feature: Dashboard


  #Scenario Outline:
  #  Given I am on Dashboard page
  # When I click on category "<category>"
  # Then I will be redirected to page "<page>"

    #Examples:
     # | category | page    |
     # | Woman    | woman   |
     # | Dresses  | dresses |

    #Example of single List<String>
  Scenario:
    Given I am on Dashboard page
    When I open Women category
    Then I should see Tops subcategories
      | T-shirts |
      | Blouses  |
    And I should see Dresses subcategories
      | Casual Dresses  |
      | Evening Dresses |
      | Summer Dresses  |