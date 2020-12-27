Feature: Is it Friday yet?
  Everybody wants to know when it's Friday

  Scenario Outline: Today is or is not Friday
    Free line - simple description of scenario
    Given today is "<day>"
    When I ask whether it's Friday yet
    Then I should be told "<answer>"

    Examples:
      | day            | answer |
      | Friday         | Yes    |
      | Sunday         | Nope   |
      | anything else! | Nope   |





    #The primary keywords are:
    #
    #Feature
    #Rule (as of Gherkin 6)
    #Example (or Scenario)
    #Given, When, Then, And, But for steps (or *)
    #Background
    #Scenario Outline (or Scenario Template)
    #Examples (or Scenarios)
    #There are a few secondary keywords as well:
    #
    #""" (Doc Strings)
    #| (Data Tables)
    #@ (Tags)
    ## (Comments)