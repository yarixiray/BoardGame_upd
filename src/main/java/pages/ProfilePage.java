package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    private WebDriver driver;
    private By myGeekMenu = By.linkText("My Geek");
    private By collectionMenu = By.linkText("Collection");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickOnMyGeekMenu() {
        driver.findElement(myGeekMenu).click();
    }

    public void clickOnTheCollection() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(collectionMenu));
        driver.findElement(collectionMenu).click();
    }

}