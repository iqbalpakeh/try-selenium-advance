package com.herokuapp.theinternet.checkboxespagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import com.herokuapp.theinternet.pages.WelcomePage;
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
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Checkboxes link
        CheckboxesPage checkboxesPage = welcomePage.clickCheckboxesLink();

        // Select all Checkboxes
        checkboxesPage.selectAllCheckboxes();

        //---------------------------------------------------------------
        // VERIFICATIONS
        //---------------------------------------------------------------

        // Verify all checkboxes are checked
        Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(), "Not all checkboxes are checked");
    }

}
