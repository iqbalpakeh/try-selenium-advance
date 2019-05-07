package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage {

    private String pageUrl = "http://the-internet.herokuapp.com/secure";

    private By logoutButton = By.xpath("//a[@class='button secondary radius']");
    private By message = By.id("flash-messages");

    public SecureAreaPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Get URL from PageObject
     *
     * @return page url
     */
    public String getPageUrl() {
        return pageUrl;
    }

    /**
     * Verification if logoutButton is visible on the page
     *
     * @return true if button visible
     */
    public boolean isLogoutButtonVisible() {
        return find(logoutButton).isDisplayed();
    }

    /**
     * Return text from success message
     *
     * @return success message text
     */
    public String getSuccessMessageText() {
        return find(message).getText();
    }

}
