package TestProject.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Optional;

public class SearchPage extends Page{

    private By searchResultsCount = By.xpath("//span[@class='heading-counter']");
    private By searchQueryParameter = By.xpath("//span[@class='lighter']");
    private By keywordNotFoundWarning = By.xpath("//p[@class='alert alert-warning']");

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
}
