package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage {

    private String pageUrl = "http://the-internet.herokuapp.com/";

    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");

    public WelcomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Open Welcome Page with its url
     */
    public void openPage() {
       log.info("Opening page: " + pageUrl);
       driver.get(pageUrl);
       log.info("Page opened!");
    }

    /**
     * Open Login Page by clicking form authentication link
     *
     * @return Login Page
     */
    public LoginPage clickFormAuthenticationLink() {
        log.info("Clicking form authentication link on welcome page");
        driver.findElement(formAuthenticationLinkLocator).click();
        return new LoginPage(driver, log);
    }

}
