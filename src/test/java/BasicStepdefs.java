import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.jayway.restassured.RestAssured.given;


public class BasicStepdefs {
    public static WebDriver driver;
    public static String baseApiUrl;

    @Given("^I am on the homepage$")
    public void open_page() {
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sony\\IdeaProjects\\geckodriver\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sony\\IdeaProjects\\chromedriver_win32\\chromedriver.exe");
//        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://boardgamegeek.com/");
        Assert.assertEquals("BoardGameGeek | Gaming Unplugged Since 2000", driver.getTitle());
    }

    @When("^login as user with password$")
    public void login() {
        driver.findElement(By.id("login_username")).sendKeys("yarixiray");
        driver.findElement(By.id("login_password")).sendKeys("12071986");
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();
    }

    @And("^navigate  to the \"My Geek\" menu$")
    public void navigateToTheMyGeek() {
        driver.findElement(By.linkText("My Geek")).click();
    }

    @And("^click on the \"Collection\"$")
    public void clickOnTheCollection() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Collection")));
        driver.findElement(By.linkText("Collection")).click();
    }

    @Then("^Board Game Collection page is open$")
    public void gameCollectionPage() {
        Assert.assertEquals("yarixiray | User Collection | BoardGameGeek", driver.getTitle());

    }


    @When("^game is chosen$")
    public void gameIsChosen() {
        int randomIndex = RandomUtils.nextInt(1, 4);
        List<WebElement> linksList = driver.findElements(By.xpath("//table[@id='collectionitems']/tbody/tr/td/div/a"));
        String gameId = linksList.get(randomIndex).getAttribute("href").split("/")[4];
        baseApiUrl = "https://boardgamegeek.com/xmlapi/boardgame/" + gameId;
        linksList.get(randomIndex).click();

    }

    @Then("^game page is open, the most voted Language Dependence level is presented$")
    public void gamePageIsOpen() {
        if (driver.findElements(By.xpath("//span[contains(@item-poll-button,'languagedependence')]")).size() != 0) {
            System.out.println("Language Dependence level is Present");
        } else {
            System.out.println("Language Dependence level is Absent");
        }

    }

    @Given("^url of the api$")
    public void urlOfTheApi() {
        given().when().get(baseApiUrl).then().statusCode(200);
        driver.close();
        driver.quit();

    }


}
