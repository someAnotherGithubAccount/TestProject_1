package TestProject.cucumberTests.steps.hooks;

import TestProject.framework.pages.Page;
import TestProject.framework.testBase.*;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks extends TestBase {

    private static final Logger log = LogManager.getLogger(Hooks.class);
    private TestBase testBase;

    public Hooks(TestBase testBase) {
        this.testBase = testBase;
    }

    @Before
    public void setUpTestBase(){
        log.info("Setting up Chrome Driver...");
        System.setProperty("webdriver.chrome.driver", "executables/chromedriver.exe");
        testBase.page  = new Page(new ChromeDriver());
    }

    @After
    public void tearDown(){
        testBase.page.tearDown();
    }
}
