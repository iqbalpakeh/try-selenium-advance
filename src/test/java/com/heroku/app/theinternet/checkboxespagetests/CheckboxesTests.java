package com.heroku.app.theinternet.checkboxespagetests;

import com.heroku.theinternet.base.TestUtilities;
import com.heroku.theinternet.pages.WelcomePageObject;
import org.testng.annotations.Test;

public class CheckboxesTests extends TestUtilities {

    @Test
    public void selectingTwoCheckboxesTests() {

        log.info("Starting selectingTwoCheckboxesTests");

        // Open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
    }

}
