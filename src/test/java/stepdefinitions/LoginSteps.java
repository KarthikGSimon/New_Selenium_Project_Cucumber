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

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @When("user opens login page")
    public void user_opens_login_page() {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);

    }

    @And("user enters username and password")
    public void user_enters_credentials() {

        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

    }

    @Then("user should see dashboard")
    public void verify_dashboard() {

        Assert.assertTrue(loginPage.verifyDashboard());

        driver.quit();

    }

}