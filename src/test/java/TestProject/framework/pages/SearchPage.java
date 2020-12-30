package TestProject.framework.pages;

import TestProject.cucumberTests.models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SearchPage extends Page{

    private By searchResultsCount = By.xpath("//span[@class='heading-counter']");
    private By searchQueryParameter = By.xpath("//span[@class='lighter']");
    private By keywordNotFoundWarning = By.xpath("//p[@class='alert alert-warning']");

    private By products = By.xpath("//div[@class='product-container']//div[@class='right-block']");

    public SearchPage(WebDriver driver) {
        super(driver);
        waitForElementToBePresent(searchResultsCount);
    }

    public String getSearchResultsCount(){
        return getText(searchResultsCount);
    }

    public Optional<String> getSearchQueryParameter(){
        return getTextEvenWhenEmpty(searchQueryParameter);
    }

    public Optional<String> getKeywordNotFoundWarning(){
        return getTextEvenWhenEmpty(keywordNotFoundWarning);
    }

    public Optional<List<Product>> getFoundedProducts(){
        waitForElementToBeVisible(products);
        List<WebElement> productsElements = getDriver().findElements(products);
        List<String> products = productsElements.stream().map(product -> product.getText()).collect(Collectors.toList());
        return Product.createListOfProducts(products);
    }
}
