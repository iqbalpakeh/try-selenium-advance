package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
     * Find all elements using given locator
     *
     * @param locator of web element
     * @return list of all web elements
     */
    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
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

    /**
     * Wait for alert present and then switch to it
     *
     * @return alert object
     */
    protected Alert switchToAlert() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    /**
     * Switch to new window with the expected title
     *
     * @param expectedTitle of new window
     */
    public void switchToWindowWithTitle(String expectedTitle) {

        // Switching to new window
        String firstWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> windowsIterator = allWindows.iterator();

        while (windowsIterator.hasNext()) {
            String windowHandle = windowsIterator.next().toString();
            if (!windowHandle.equals(firstWindow)) {
                driver.switchTo().window(windowHandle);
                if (getCurrentPageTitle().equals(expectedTitle)) {
                    break;
                }
            }
        }
    }

    /**
     * Get current page title
     *
     * @return current page title
     */
    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    /**
     * Get source of current page
     *
     * @return current page source
     */
    public String getCurrentPageSource() {
        return driver.getPageSource();
    }

    /**
     * Perform scroll to the bottom
     */
    public void scrollToBottom() {
        log.info("Scrolling to the bottom of the page");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /**
     * Switch to iFrame using it's locator
     *
     * @param frameLocator iFrame target
     */
    protected void switchToFrame(By frameLocator) {
        driver.switchTo().frame(find(frameLocator));
    }

}
