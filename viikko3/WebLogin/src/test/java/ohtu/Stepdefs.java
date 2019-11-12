package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.junit.Assert.*;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        clickLinkAtBase("login");  
    }

    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }

    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }

    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }

    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }

    @When("username {string} and password {string} are given")
    public void usernameAndPasswordAreGiven(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @Then("system will respond {string}")
    public void systemWillRespond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }

    @When("nonexistent username {string} and password {string} are given")
    public void nonexistentUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }

    @Given("command new user is selected")
    public void commandNewUserIsSelected() {
        clickLinkAtBase("register new user");
    }

    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void aValidUsernameAndPasswordAndMatchingPasswordConfirmationAreEntered(String username, String password) {
        registerWith(username, password);
    }

    @Then("a new user is created")
    public void aNewUserIsCreated() {
        pageHasContent("Welcome to Ohtu Application!");
    }

    @When("when too short username {string} and valid password {string} and matching password confirmation are entered")
    public void whenTooShortUsernameAndValidPasswordAndMatchingPasswordConfirmationAreEntered(String username,
            String password) {
        registerWith(username, password);
    }

    @Then("user is not created and error {string} is reported")
    public void userIsNotCreatedAndErrorIsReported(String error) {
        pageHasContent(error);
    }

    @When("a valid username {string} and too short password {string} and matching password confirmation are entered")
    public void aValidUsernameAndTooShortPasswordAndMatchingPasswordConfirmationAreEntered(String username,
            String password) {
        registerWith(username, password);
    }

    @When("a valid username {string} and password {string} and not matching password confirmation {string} are entered")
    public void aValidUsernameAndPasswordAndNotMatchingPasswordConfirmationAreEntered(String username, String password,
            String password2) {
        registerWith(username, password, password2);
    }

    @When("a valid username {string} and poor password {string} and matching password confirmation are entered")
    public void aValidUsernameAndPoorPasswordAndMatchingPasswordConfirmationAreEntered(String username,
            String password) {
        registerWith(username, password);
    }

    @Given("user with username {string} with password {string} is successfully created")
    public void userWithUsernameWithPasswordIsSuccessfullyCreated(String username, String password) {
        clickLinkAtBase("register new user");
        registerWith(username, password);
    }

    @When("existing username {string} with password {string} are entered")
    public void existingUsernameWithPasswordAreEntered(String username, String password) {
        logInWith(username, password);
    }

    @Then("user is logged in succesfully")
    public void userIsLoggedInSuccesfully() {
        pageHasContent("Ohtu Application main page");
    }

    @Given("user with username {string} and password {string} is tried to be created")
    public void userWithUsernameAndPasswordIsTriedToBeCreated(String username, String password) {
        clickLinkAtBase("register new user");
        registerWith(username, password);
    }

    @When("non-existing username {string} and password {string} are entered")
    public void nonExistingUsernameAndPasswordAreEntered(String username, String password) {
        logInWith(username, password);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /* helper methods */

    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        fillFieldWith("username", username);
        fillFieldWith("password", password);
        submitByName("login");
    }

    private void registerWith(String username, String password) {
        registerWith(username, password, password);
    }

    private void registerWith(String username, String password, String password2) {
        fillFieldWith("username", username);
        fillFieldWith("password", password);
        fillFieldWith("passwordConfirmation", password2);
        submitByName("signup");
    }

    private void fillFieldWith(String name, String keys) {
        WebElement element = driver.findElement(By.name(name));
        element.sendKeys(keys);
    }

    private void submitByName(String name) {
        WebElement element = driver.findElement(By.name(name));
        element.submit();
}

private void clickLinkAtBase(String text) {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText(text));       
        element.click(); 
    }
}
