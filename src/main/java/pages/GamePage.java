package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GamePage {

    private WebDriver driver;
    private By langDependence = By.xpath("//span[contains(@item-poll-button,'languagedependence')]");

    public GamePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void languageDependenceCheck() {
        Assert.assertTrue(driver.findElements(langDependence).size() != 0);
    }
}