package TestProject.framework.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class Page extends AbstractPage {

    private static final Logger log = LogManager.getLogger(Page.class);

    private By dashboardLogo = By.xpath("//img[@class='logo img-responsive']");

    public Page(WebDriver driver) {
        super(driver);
    }

    public DashboardPage goToDashboardPage(){
        log.info("Going to Dashboard page...");
        getDriver().get("http://automationpractice.com/index.php");
        waitForElementToBePresent(dashboardLogo);
        getDriver().manage().window().maximize();
        return new DashboardPage(getDriver());
    }

    //WAITS

    protected WebDriverWait getDefaultWait(){
        return new WebDriverWait(getDriver(),10);
    }

    public void waitABit(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        }catch (InterruptedException e){ }
    }

    protected void waitForElementToBePresent(By locator){
        getDefaultWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void waitForElementToContainsText(By locator){
        getDefaultWait().until(new ExpectedCondition<Object>() {
            @NullableDecl
            @Override
            public Object apply(@NullableDecl WebDriver driver) {
                return driver.findElement(locator).getText().length() != 0;
            }
        });
    }

    //UTILITY METHODS

    protected void focusOnElement(By elementToFocus,ExecutionMethod executionMethod){
        switch (executionMethod){
            case SELENIUM:
                waitForElementToBePresent(elementToFocus);
                Actions actions = new Actions(getDriver());
                actions.moveToElement(getDriver().findElement(elementToFocus));
                actions.build().perform();
                break;
            case JAVASCRIPT:
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(elementToFocus));
                break;
        }
        waitABit(500);
    }


    //TEXT METHODS

    protected String getText(By locatorWithText){
        waitForElementToContainsText(locatorWithText);
        return getDriver().findElement(locatorWithText).getText();
    }

    protected List<String> getTexts(By locatorWithText){
        waitForElementToBePresent(locatorWithText);
        List<WebElement> elementsWithText = getDriver().findElements(locatorWithText);
        return elementsWithText.stream().map(element -> element.getText()).collect(Collectors.toList());
    }

    public enum ExecutionMethod{
        SELENIUM,
        JAVASCRIPT;
    }

}