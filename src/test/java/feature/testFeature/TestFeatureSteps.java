package edu.csumb.cst438fa16.hangman;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import cucumber.api.Format;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestFeatureSteps {
    WebDriver driver = new ChromeDriver();
    String response = "";

    /**
     * Acceptance Test
     * As a user I want to be able to enter guesses into the text box
     * When I enter "c" and press submit
     * Then I see my response back as a oldGuess
     */

    @When("^I enter c  into the guess box$")
        public void i_enter_c_into_the_guess_box() throws Throwable {
            driver.get("http://localhost:8080/hangman.html");
            driver.findElement(By.id("newGuesses")).sendKeys("c");
            driver.findElement(By.id("submit")).click();

            response = driver.findElement(By.id("oldGuesses")).getText();
        }
    @Then("^c should be given to me as an oldGuess$")
        public void c_should_be_given_to_me_as_an_oldGuess() throws Throwable {
            assertThat("response", equalTo("c"));
            driver.quit();
        }
}
