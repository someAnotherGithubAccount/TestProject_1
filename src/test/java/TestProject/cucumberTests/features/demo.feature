Feature: Demo feature

Scenario: Demonstrating how Cucumber-JVM works
    Given I have a configured Cucumber-JVM project
    And my Java SDK is set to
    """
    Version 1.8 preferably but Version 1.9 will do the job as well
    """
    When I run it within my IDE
    Then I will be "able" to run connected step definitions
    And I will be logged as User
        | username | password |
        | user1    | pas1     |
        | user2    | pas123   |

    #DataTables example -> DataTable != ScenarioOutline
    #Doc Strings and Data Tables will be passed to the step definition as the last argument



