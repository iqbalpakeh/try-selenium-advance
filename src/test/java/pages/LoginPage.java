package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private Logger log;

    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By loginButtonLocator = By.id("button");

    public LoginPage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    /**
     * Execute login
     *
     * @param username information
     * @param password information
     * @return Secure Area Page
     */
    public SecureAreaPage login(String username, String password) {
        log.info("Executing login with username [" + username + "] and password [" +password+ "]");
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
        return new SecureAreaPage(driver, log);
    }

}
