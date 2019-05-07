package com.herokuapp.theinternet.checkboxespagetests;

import com.heroku.theinternet.base.TestUtilities;
import com.heroku.theinternet.pages.CheckboxesPageObject;
import com.heroku.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTests extends TestUtilities {

    @Test
    public void selectingTwoCheckboxesTests() {

        log.info("Starting selectingTwoCheckboxesTests");

        //---------------------------------------------------------------
        // EXECUTION
        //---------------------------------------------------------------

        // Open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        // Click on Checkboxes link
        CheckboxesPageObject checkboxesPage = welcomePage.clickCheckboxesLink();

        // Select all Checkboxes
        checkboxesPage.selectAllCheckboxes();

        //---------------------------------------------------------------
        // VERIFICATIONS
        //---------------------------------------------------------------

        // Verify all checkboxes are checked
        Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(), "Not all checkboxes are checked");
    }

}
