package TestProject.cucumberTests.steps;

import TestProject.cucumberTests.models.User;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class DemoFeatureSteps {
    private static final Logger log = LogManager.getLogger(DemoFeatureSteps.class);

    @Given("I have a configured Cucumber-JVM project")
    public void iHaveAConfiguredCucumberJVMProject() {
        log.info("Given step: I have a configured Cucumber-JVM project");
    }

    @When("I run it within my IDE")
    public void iRunItWithinMyIDE() {
        log.info("When step: I run it within my IDE");
    }

    @Then("I will be able to run connected step definitions")
    public void iWillBeAbleToRunConnectedStepDefinitions() {
        log.info("When step");
    }

    @Then("I will be {string} to run connected step definitions")
    public void iWillBeToRunConnectedStepDefinitions(String arg0) {
        log.info("When step with parameter: I will be \"able\" to run connected step definitions");
        log.info(arg0);

    }

    @And("I will be logged as User")
    public void iWillBeLoggedAsUser(List<User> dataTable) {
        log.info("When list parameter list: I will be logged as User");
        List<User> users;
        users = dataTable;
        log.info(users.toString());
    }

    @And("my Java SDK is set to")
    public void myJavaSDKIsSetTo(String longArgument) {
        log.info("Given Step: My Java SDK is set to "+longArgument);
    }
}
