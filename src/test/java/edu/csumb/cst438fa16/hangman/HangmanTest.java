package edu.csumb.cst438fa16.hangman;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Test;

public class HangmanTest {

    WebDriver driver = new ChromeDriver();
    @Test
    public void testEmptyWord() {
	Hangman hangman = new Hangman("");
	assertThat(hangman.start(), equalTo(""));
	assertThat(hangman.match("abcdefghijklmnopqrstuvwxyz"), equalTo(""));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testUpperCaseWord() {
	Hangman hangman = new Hangman("A");
    }

    @Test
    public void testStart() {
	Hangman hangman = new Hangman("cat");
	assertThat(hangman.start(), equalTo("..."));
    }

    @Test
    public void testEmptyMatch() {
	Hangman hangman = new Hangman("cat");
	assertThat(hangman.match(""), equalTo("..."));
    }

    @Test
    public void testMisMatch() {
	Hangman hangman = new Hangman("cat");
	assertThat(hangman.match("xyz"), equalTo("..."));
    }

    @Test
    public void testPartialMatch() {
	Hangman hangman = new Hangman("cat");
	assertThat(hangman.match("abcd"), equalTo("ca."));
    }

    @Test
    public void testAllMatch() {
	Hangman hangman = new Hangman("cat");
	assertThat(hangman.match("catz"), equalTo("cat"));
    }

    @Before
    public void setUp() {
        driver.get("http://localhost:8080/hangman.html");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /**
     * Acceptance test:
     *
     * Given I am on the hangman page
     * When I enter "c" and press submit
     * Then I see my submission in the 'pattern' space
     */
    @Test
    public void testSubmitC() {
        driver.findElement(By.id("newGuesses")).sendKeys("c");
        driver.findElement(By.id("submit")).click();

        // we should see the letter 'c' appear in the oldGuesses field
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.textToBe(By.id("oldGuesses"), "c"));
    }
}
