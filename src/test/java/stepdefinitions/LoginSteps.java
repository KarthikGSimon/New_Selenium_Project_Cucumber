package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;

import pages.LoginPage;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("user launches browser")
    public void user_launches_browser() {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    @When("user opens login page")
    public void user_opens_login_page() {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);

    }

    @And("user enters {string} and {string}")
    public void user_enters_credentials(String username, String password) {

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

    }

    @Then("user should see {string}")
    public void verify_dashboard(String output) {

        if (output.equals("dashboard")) {
            Assert.assertTrue(loginPage.verifyDashboard());
        } else {
            Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        }
        driver.quit();

    }
}