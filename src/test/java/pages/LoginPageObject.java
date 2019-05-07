package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePageObject {

    private By usernameLocator = By.id("username");
    private By passwordLocator = By.name("password");
    private By loginButtonLocator = By.tagName("button");
    private By errorMessageLocator = By.id("flash");

    public LoginPageObject(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Execute login with correct credential information
     *
     * @param username credential information
     * @param password credential information
     * @return Secure Area Page
     */
    public SecureAreaPageObject login(String username, String password) {
        log.info("Executing login with username [" + username + "] and password [" +password+ "]");
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(loginButtonLocator);
        return new SecureAreaPageObject(driver, log);
    }

    /**
     * Execute login with incorrect credential information
     *
     * @param username credential information
     * @param password credential information
     */
    public void negativeLogin(String username, String password) {
        log.info("Executing Negative Login with username [" + username + "] and password [" + password + "]");
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(loginButtonLocator);
    }

    /**
     * Wait for error message to be visible on the page
     */
    public void waitForErrorMessage() {
        waitForVisibilityOf(errorMessageLocator, 5);
    }

    /**
     * Get error message when login error
     *
     * @return error message
     */
    public String getErrorMessageText() {
        return find(errorMessageLocator).getText();
    }

}
