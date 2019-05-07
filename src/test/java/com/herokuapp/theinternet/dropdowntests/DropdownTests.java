package com.herokuapp.theinternet.dropdowntests;

import com.heroku.theinternet.base.TestUtilities;
import com.heroku.theinternet.pages.WelcomePageObject;
import com.heroku.theinternet.pages.DropdownPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTests extends TestUtilities {

    @Test
    public void optionTwoTest() {

        log.info("Starting optionTwoTest");

        //---------------------------------------------------------------
        // EXECUTION
        //---------------------------------------------------------------

        // Open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        // Click dropdown link
        DropdownPageObject dropdownPage = welcomePage.clickDropdownLink();

        // Select Option 2
        dropdownPage.selectOption(2);

        //---------------------------------------------------------------
        // VERIFICATIONS
        //---------------------------------------------------------------

        // Verify option 2 is selected
        String selectedOption = dropdownPage.getSelectedOption();
        Assert.assertTrue(selectedOption.equals("Option 2"),
                "Option 2 is not selected. Instead selected - " + selectedOption);

    }

}
