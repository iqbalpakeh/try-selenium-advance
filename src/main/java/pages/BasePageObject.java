package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {

    protected WebDriver driver;
    protected Logger log;

    public BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    /**
     * Open page with given url
     *
     * @param url of page to open
     */
    protected void openUrl(String url) {
        driver.get(url);
    }

    /**
     * Find element using given locator
     *
     * @param locator of web element
     * @return web element
     */
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    /**
     * Click on element with given locator when it's visible
     *
     * @param locator of web element
     */
    protected void click(By locator) {
        waitForVisibilityOf(locator, 5);
        find(locator).click();
    }

    /**
     * Type given text into element with given locator
     *
     * @param text to type
     * @param locator of web element
     */
    protected void type(String text, By locator) {
        waitForVisibilityOf(locator, 5);
        find(locator).sendKeys(text);
    }

    /**
     * Get URL of current page from browser
     *
     * @return page URL
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Wait for given number of seconds for element with given locator to be visible on the page
     *
     * @param locator of web element
     * @param timeOutInSeconds to wait
     */
    protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOutInSeconds.length > 0? timeOutInSeconds[0] : null));
                break;
            } catch(StaleElementReferenceException e) {
                e.printStackTrace();
            }
            attempts++;
        }
    }

    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(condition);
    }

}
