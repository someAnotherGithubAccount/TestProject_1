package TestProject.framework.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    private static final Logger log = LogManager.getLogger(AbstractPage.class);

    private WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver getDriver(){
        return driver;
    }

    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
