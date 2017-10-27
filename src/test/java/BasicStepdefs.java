import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CollectionPage;
import pages.GamePage;
import pages.HomePage;
import pages.ProfilePage;


public class BasicStepdefs extends BaseTest {

    @Given("^I am on the homepage$")
    public void openMyProfilePage() {
        setUp();
        HomePage homePage = new HomePage(driver);
        homePage.loginForUser("yarixiray", "12071986");
        homePage.clickOnSignInButton();
    }

    @When("^Open the game collection of a user$")
    public void openTheGameCollection() {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickOnMyGeekMenu();
        profilePage.clickOnTheCollection();
    }

    @And("^Go to the page of one of the games \\(chosen at random\\)$")
    public void navigateToTheMyGeek() {
        CollectionPage collectionPage = new CollectionPage(driver);
        collectionPage.gameIsChosen();
    }

    @Then("^Check the information about the game - especially the poll about Language Dependence$")
    public void clickOnTheCollection() {
        CollectionPage linkURL = new CollectionPage(driver);
        System.out.println(linkURL.doGet());
    }

    @And("^Verify that the most voted Language Dependence level is presented on the game's page$")
    public void gamePageIsOpen() {
        GamePage gamePage = new GamePage(driver);
        gamePage.languageDependenceCheck();
        tearDown();
    }
}
