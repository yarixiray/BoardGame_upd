package pages;

import com.jayway.restassured.RestAssured;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.given;


public class CollectionPage {
    private WebDriver driver;
    private By linkToGame = By.xpath("//table[@id='collectionitems']/tbody/tr/td/div/a");


    public CollectionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void gameIsChosen() {
        List<WebElement> linksList = driver.findElements(linkToGame);
        int randomIndex = RandomUtils.nextInt(1, linksList.size());
        linksList.get(randomIndex).click();
    }

    public String doGet() {
        String gameId = driver.getCurrentUrl().split("/")[4];
        RestAssured.baseURI = "https://boardgamegeek.com/xmlapi/boardgame/" + gameId;
        String res = given()
                .param("query")
                .param("key")
                .when()
                .get(baseURI)
                .then()
                .extract()
                .path("boardgames.boardgame.name");
        return res;
    }
}

