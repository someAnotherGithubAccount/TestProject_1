package TestProject.cucumberTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue={"src/test/java/TestProject/resources/steps"}

)

public class RunCucumberTest {

    /*
    A simple features file consists of the following keywords/parts −

    Feature − Name of the features under test.

    Description (optional) − Describe about features under test.

            Scenario − What is the test scenario.

            Given − Prerequisite before the test steps get executed.

            When − Specific condition which should match in order to execute the next step.

    Then − What should happen if the condition mentioned in WHEN is satisfied.
    */
}
