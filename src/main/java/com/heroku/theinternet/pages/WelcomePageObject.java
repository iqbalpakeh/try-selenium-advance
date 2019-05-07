package com.heroku.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject {

    private String pageUrl = "http://the-internet.herokuapp.com/";

    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
    private By checkboxesLinkLocator = By.linkText("Checkboxes");

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

    /**
     * Open CheckboxesPage by clicking on Checkboxes Link
     *
     * @return Checkboxes page
     */
    public CheckboxesPageObject clickCheckboxesLink() {
        log.info("Clicking checkboxes link on Welcome Page");
        click(checkboxesLinkLocator);
        return new CheckboxesPageObject(driver, log);
    }

}
