package TestProject.framework.pages;

import TestProject.cucumberTests.models.Product;
import TestProject.cucumberTests.steps.DashboardSteps;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static TestProject.framework.pages.Page.ExecutionMethod.*;

public class DashboardPage extends Page {

    private static final Logger log = LogManager.getLogger(DashboardSteps.class);

    private By womanMainCategory = By.xpath("//div[@id='block_top_menu']/ul/li[1]");
    private By dressesMainCategory = By.xpath("//div[@id='block_top_menu']/ul/li[2]");

    private By womanSubcategoryTops = By.xpath("//div[@id='block_top_menu']//li[@class]//a[@title='Women']//following-sibling::ul//a[@title='Tops']//following-sibling::ul//li");
    private By womanSubcategoryDresses = By.xpath("//div[@id='block_top_menu']//li[@class]//a[@title='Women']//following-sibling::ul//a[@title='Dresses']//following-sibling::ul//li");

    private By topSearchInput = By.xpath("//input[@id='search_query_top']");
    private By submitSearchButton = By.xpath("//button[@name='submit_search']");

    private By popularProducts = By.xpath("//ul[@id='homefeatured']//div[@class='right-block']");

    private By popularProductsActiveTab = By.xpath("//a[@class='homefeatured']//ancestor::li[@class='active']");
    private By bestsellersProductActiveTab = By.xpath("//a[@class='class='blockbestsellers']//ancestor::li[@class='active']");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCategoryByName(String category){
        switch (category){
            case "Woman":
                clickOnWomanCategory();
                break;
            case "Dresses":
                clickOnDressesCategory();
                break;
        }
    }

    public void openWomanCategory(){
        focusOnElement(womanMainCategory, SELENIUM);
    }

    public void clickOnWomanCategory(){
        waitForElementToBePresent(womanMainCategory);
        getDriver().findElement(womanMainCategory).click();
    }

    public void clickOnDressesCategory(){
        waitForElementToBePresent(dressesMainCategory);
        getDriver().findElement(dressesMainCategory).click();
    }

    public List<String> getWomanTopsSubcategories(){
        return getTexts(womanSubcategoryTops);
    }

    public List<String> getWomanDressesSubcategories(){
        return getTexts(womanSubcategoryDresses);
    }

    public SearchPage searchFor(String text){
        sendKeys(topSearchInput,text);
        clickOn(submitSearchButton);
        return new SearchPage(getDriver());
    }

    public Optional<List<Product>> getPopularProducts(){
        waitForElementToBeVisible(popularProducts);
        List<WebElement> productsElements = getDriver().findElements(popularProducts);
        List<String> products = productsElements.stream().map(product -> product.getText()).collect(Collectors.toList());
        return Product.createListOfProducts(products);
    }

    public boolean isCategorySelected(String category){
        switch (category){
            case "Popular":
                return isElementDisplayed(popularProductsActiveTab);
            case "Bestsellers":
                return isElementDisplayed(bestsellersProductActiveTab);
            default:
                throw new IllegalArgumentException("No such category: "+category);
        }
    }
}
