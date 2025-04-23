package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class GherSampleSteps {
    int currentNumber = 0;
    @Given("I have {int} cucumbers")
    public void iHaveCucumbers(int currentNumberOfCuc) {
        currentNumber = currentNumberOfCuc;
    }

    @When("I eat {int} cucumbers")
    public void iEatCucumbers(int numberOfEatenCuc) {
        currentNumber -= numberOfEatenCuc;
    }

    @Then("I have {int} cucumbers remaining")
    public void iHaveCucumbersRemaining(int numberOfRemainingCuc) {
        Assertions.assertEquals(numberOfRemainingCuc, currentNumber);
    }

    @And("I am {string}")

    public void iAmHappy(String word) {
        System.out.println(word);
    }
}
