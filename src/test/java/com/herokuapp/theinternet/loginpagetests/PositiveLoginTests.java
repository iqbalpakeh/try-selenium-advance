package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class PositiveLoginTests extends TestUtilities {

    @Test
    public void positiveLoginTest() {

        log.info("Starting logIn test");

        //---------------------------------------------------------------
        // EXECUTION
        //---------------------------------------------------------------

        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
        SecureAreaPage secureAreaPage = loginPage.login("tomsmith", "SuperSecretPassword!");

        //---------------------------------------------------------------
        // VERIFICATIONS
        //---------------------------------------------------------------

        // Check new url
        Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());

        // Check if logout button visible
        Assert.assertTrue(secureAreaPage.isLogoutButtonVisible(), "logOutButton is not visible.");

        // Check successful login message
        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                        + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
    }

}
