package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject {

    private String pageUrl = "http://the-internet.herokuapp.com/";

    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");

    public WelcomePageObject(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Open Welcome Page with its url
     */
    public void openPage() {
       log.info("Opening page: " + pageUrl);
       openUrl(pageUrl);
       log.info("Page opened!");
    }

    /**
     * Open Login Page by clicking form authentication link
     *
     * @return Login Page
     */
    public LoginPageObject clickFormAuthenticationLink() {
        log.info("Clicking form authentication link on welcome page");
        click(formAuthenticationLinkLocator);
        return new LoginPageObject(driver, log);
    }

}
