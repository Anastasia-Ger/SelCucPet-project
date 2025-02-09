package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.GoPage;

import java.time.Duration;
import java.util.List;

public class GoSteps {
    WebDriver driver;
    WebDriverWait wait;
//    String currentLanguage;
    GoPage goPage;
    String pageLanguage;

    @Before
    public void initializeDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @After
    public void closeDriver() {
        driver.quit();
    }

    @Given("I open Go website")
    public void iOpenGoWebsite() {
        driver.get("https://futar.bkk.hu");
        goPage = new GoPage(driver);
    }

    @And("I accept privacy policy")
    public void iAcceptPrivacyPolicy() {
        goPage.acceptPrivacyPolicy();
    }

    @And("language is set to {string}")
    public void languageIsSetTo(String currentLanguage) {
        String pageLanguage;
        if (goPage.isTitleSetToEnglish()) {
            pageLanguage = "english";
        } else {
            pageLanguage = "hungarian";
        }


        if (pageLanguage.equals("english") && currentLanguage.equals("hungarian")) {
            goPage.clickHungarianBTN();

        }
        if (pageLanguage.equals("hungarian") && currentLanguage.equals("english")) {
            goPage.clickEnglishBTN();

        }

    }

    @When("I change language to {string}")
    public void iChangeLanguageTo(String newLanguage) {
        if (newLanguage.equals("english")) {
            goPage.waitForTitle();
            goPage.clickEnglishBTN();

        } else {
            goPage.waitForTitle();
            goPage.clickHungarianBTN();

        }
    }

    @Then("language is changed to {string}")
    public void languageIsChangedTo(String expectedLanguage) {
        goPage.waitForTitle();
        if (goPage.isTitleSetToEnglish()) {
           pageLanguage = "english";
        } else {
           pageLanguage = "hungarian";
        }
        Assertions.assertEquals(expectedLanguage, pageLanguage);


    }

    @When("I change language multiple times to the following:")
    public void iChangeLanguageMultipleTimesToTheFollowing(List<String> languages){
        for (int i=0; i<languages.size(); i++){
            iChangeLanguageTo(languages.get(i));
        }

    }

    @When("I change language multiple times with a DataTable:")
    public void iChangeLanguageMultipleTimesWithADataTable(DataTable dataTable) {
    }
}

