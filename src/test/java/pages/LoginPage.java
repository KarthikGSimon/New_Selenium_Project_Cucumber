package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class LoginPage {

    WebDriver driver;
    WaitUtils wait;

    By username = By.name("username");
    By password = By.name("password");
    By loginBtn = By.xpath("//button[@type='submit']");
    By dashboard = By.xpath("//div[@class='oxd-layout-container']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void enterUsername(String user) {
        wait.waitForElementPresent(username);
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        wait.waitForElementPresent(password);
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public boolean verifyDashboard() {
        wait.waitForElementPresent(dashboard);
        return driver.findElement(dashboard).isDisplayed();
    }
    public boolean isErrorMessageDisplayed() {
        wait.waitForElementPresent(dashboard);
        return driver.findElement(dashboard).isDisplayed();
    }

}