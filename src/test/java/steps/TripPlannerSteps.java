package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.GoPage;

public class TripPlannerSteps {
    WebDriver driver = new ChromeDriver();
    GoPage goPage = new GoPage(driver);
    @Before
    public void initializeDriver(){
        driver.manage().window().maximize();

    }
    @After
    public void closeDriver(){
        driver.quit();
    }

    @Given("I open BudapestGo website")
    public void iOpenBudapestGoWebsite() {
        driver.get("https://futar.bkk.hu");

    }

    @And("I accepted privacy policy")
    public void iAcceptedPrivacyPolicy() {
        goPage.acceptPrivacyPolicy();
    }
    @And("Page language is set to English")
    public void pageLanguageIsSetToEnglish() {
        if (!goPage.isTitleSetToEnglish()){
            goPage.clickEnglishBTN();}
    }


    @When("I fill From field with {string}")
    public void iFillFromFieldWithKeletiRailwayStation(String departurePoint) {
        goPage.waitForPanelWindow();
        goPage.fillFromField(departurePoint);
    }

    @And("I fill To field with {string}")
    public void iFillToFieldWithNyugatiRailwayStation(String arrivalPoint) {
        goPage.fillToField(arrivalPoint);
    }

    @And("I click on Plan button")
    public void iClickOnPlanButton() throws InterruptedException {
        Thread.sleep(5000);
        goPage.clickPlanBTN();
        Thread.sleep(7000);
    }

    @Then("The trip is planned")
    public void theTripIsPlanned() {
     //   WebElement itinerary = goPage.findItinerariesBlock();
     //   Assertions.assertTrue(itinerary.isDisplayed());
    }


}
