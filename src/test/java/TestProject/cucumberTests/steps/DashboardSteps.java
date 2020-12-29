package TestProject.cucumberTests.steps;

import TestProject.framework.testBase.TestBase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DashboardSteps extends TestBase{

    private static final Logger log = LogManager.getLogger(DashboardSteps.class);

    private TestBase testBase;

    private List<String> womenTopsSubcategories;
    private List<String> womenDressesSubcategories;

    public DashboardSteps(TestBase testBase) {
        this.testBase = testBase;
        this.page = testBase.page;
    }

    @Given("I am on Dashboard page")
    public void iAmOnDashboardPage() {
         dashboardPage = page.goToDashboardPage();
    }

    @When("I click on category {string}")
    public void iClickOnCategory(String arg0) {
        log.info("Clicking on category: "+arg0);
        dashboardPage.clickOnCategoryByName(arg0);
    }

    @Then("I will be redirected to page {string}")
    public void iWillBeRedirectedToPage(String arg0) {
        log.info("On page "+arg0);
    }

    @When("I open Women category")
    public void iOpenWomenCategory() {
        dashboardPage.openWomanCategory();
    }

    @Then("I should see Tops subcategories")
    public void iShouldSeeTopsSubcategories(List<String> expectedTopSubcategories) {
        womenTopsSubcategories = dashboardPage.getWomanTopsSubcategories();
        assertThat(womenTopsSubcategories).as("Woman Top subcategories").containsExactlyElementsOf(expectedTopSubcategories);
    }

    @And("I should see Dresses subcategories")
    public void iShouldSeeDressesSubcategories(List<String> expectedDressesSubcategories) {
        womenDressesSubcategories = dashboardPage.getWomanDressesSubcategories();
        assertThat(womenDressesSubcategories).as("Woman Dresses subcategories").containsExactlyElementsOf(expectedDressesSubcategories);
    }
}
