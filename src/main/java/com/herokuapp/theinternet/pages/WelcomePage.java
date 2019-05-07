package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject {

    private String pageUrl = "http://the-internet.herokuapp.com/";

    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
    private By checkboxesLinkLocator = By.linkText("Checkboxes");
    private By dropdownLinkLocator = By.linkText("Dropdown");
    private By javaScriptAlertsLinkLocator = By.linkText("JavaScript Alerts");

    public WelcomePage(WebDriver driver, Logger log) {
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
    public LoginPage clickFormAuthenticationLink() {
        log.info("Clicking form authentication link on welcome page");
        click(formAuthenticationLinkLocator);
        return new LoginPage(driver, log);
    }

    /**
     * Open CheckboxesPage by clicking on Checkboxes Link
     *
     * @return Checkboxes page
     */
    public CheckboxesPage clickCheckboxesLink() {
        log.info("Clicking checkboxes link on Welcome Page");
        click(checkboxesLinkLocator);
        return new CheckboxesPage(driver, log);
    }

    /**
     * Click dropdown page by clicking Dropdown Link
     *
     * @return
     */
    public DropdownPage clickDropdownLink() {
        log.info("Clicking Dropdown link on Welcome Page");
        click(dropdownLinkLocator);
        return new DropdownPage(driver, log);
    }

    /**
     * Click alert page by clicking alert link
     *
     * @return alert page
     */
    public JavaScriptAlertsPage clickJavaScriptAlertsLink() {
        log.info("Clicking JavaScript Alerts link on Welcome Page");
        click(javaScriptAlertsLinkLocator);
        return new JavaScriptAlertsPage(driver, log);
    }

}
