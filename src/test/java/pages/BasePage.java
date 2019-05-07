package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected Logger log;

    public BasePage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }
}
