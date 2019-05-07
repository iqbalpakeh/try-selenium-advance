package com.herokuapp.theinternet.dropdowntests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.WelcomePage;
import com.herokuapp.theinternet.pages.DropdownPage;
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
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click dropdown link
        DropdownPage dropdownPage = welcomePage.clickDropdownLink();

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
