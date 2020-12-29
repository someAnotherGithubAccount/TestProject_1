Feature: Dashboard


  #Scenario Outline:
  #  Given I am on Dashboard page
  # When I click on category "<category>"
  # Then I will be redirected to page "<page>"

    #Examples:
     # | category | page    |
     # | Woman    | woman   |
     # | Dresses  | dresses |

  #Example of single String parameter
  #Example of single int parameter
  Scenario:
    Given I am on Dashboard page
    When I search for ""
    Then I should see 0 results
    And I should see warning text

    #Steps 'When I search for <String>' and 'I should see <int> results' can be reused
  Scenario:
    Given I am on Dashboard page
    When I search for "dress"
    Then I should see 7 results

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