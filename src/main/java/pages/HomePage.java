package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;
    private static String pageUrl = "https://boardgamegeek.com/";
    private By loginUsernameField = By.id("login_username");
    private By loginPasswordField = By.id("login_password");
    private By signInButton = By.cssSelector("input[value='Sign in']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(pageUrl);
        PageFactory.initElements(driver, this);
    }

    public void loginForUser(String name, String password) {
        driver.findElement(loginUsernameField).sendKeys(name);
        driver.findElement(loginPasswordField).sendKeys(password);
    }

    public void clickOnSignInButton() {

        driver.findElement(signInButton).click();
    }
}
