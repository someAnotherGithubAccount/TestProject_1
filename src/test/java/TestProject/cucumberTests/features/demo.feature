Feature: Demo feature

Scenario: Demonstrating how Cucumber-JVM works
    Given I have a configured Cucumber-JVM project
    When I run it within my IDE
    Then I will be "able" to run connected step definitions
    And I will be logged as User
        | username | password |
        | user1    | pas1     |
        | user2    | pas123   |
