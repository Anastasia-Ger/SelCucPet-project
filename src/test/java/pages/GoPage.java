package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoPage {
    //Elements
    private final By ACCEPT_BTN = By.xpath("//button[contains(text(),'Accept')]");
    private final By TITLE_TEXT = By.tagName("h2");
    private final By HUNGARIAN_FLAG_BTN = By.xpath("//span[@title='magyar']");
    private final By ENGLISH_FLAG_BTN = By.xpath("//span[@title='english']");
    private final By FROM_FIELD = By.xpath("//input[contains(@class, 'planner-from')]");
    private final By TO_FIELD = By.xpath("//input[contains(@class, 'planner-to')]");
    private final By PLAN_BTN = By.xpath("//input[@type='submit']");
    private final By PANEL_WINDOW = By.xpath("//div[@id='panel-window']");
    private final By ITINERARIES_BLOCK = By.xpath("//h2[contains(text(), 'Suggested itineraries')]");

    WebDriver driver;
    WebDriverWait wait;
    public GoPage (WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //Actions

    public void waitForTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_TEXT));
    }
    public void waitForPanelWindow (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(PANEL_WINDOW));
    }
    public void acceptPrivacyPolicy (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACCEPT_BTN));
        driver.findElement(ACCEPT_BTN).click();
    }
    public boolean isTitleSetToEnglish (){
        return driver.findElement(TITLE_TEXT).getText().equals("Trip Planner");
    }
    public void clickEnglishBTN (){
        driver.findElement(ENGLISH_FLAG_BTN).click();
    }
    public void clickHungarianBTN (){
        driver.findElement(HUNGARIAN_FLAG_BTN).click();
    }
    public void fillFromField (String departure){
      driver.findElement(FROM_FIELD).sendKeys(departure);

    }
    public void fillToField (String arrival){
      driver.findElement(TO_FIELD).sendKeys(arrival);
    }
    public void clickPlanBTN () throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PLAN_BTN));
        WebElement planBTN = driver.findElement(PLAN_BTN);
        planBTN.click();
        planBTN.submit();

    }
    public WebElement findItinerariesBlock (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ITINERARIES_BLOCK));
        return driver.findElement(ITINERARIES_BLOCK);
    }

}
