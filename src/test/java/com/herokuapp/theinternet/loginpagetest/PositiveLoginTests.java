package com.herokuapp.theinternet.loginpagetest;

import com.heroku.theinternet.base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.heroku.theinternet.pages.LoginPageObject;
import com.heroku.theinternet.pages.SecureAreaPageObject;
import com.heroku.theinternet.pages.WelcomePageObject;

public class PositiveLoginTests extends TestUtilities {

    @Test
    public void positiveLoginTest() {

        log.info("Starting logIn test");

        //---------------------------------------------------------------
        // EXECUTION
        //---------------------------------------------------------------

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();
        LoginPageObject loginPage = welcomePage.clickFormAuthenticationLink();
        SecureAreaPageObject secureAreaPage = loginPage.login("tomsmith", "SuperSecretPassword!");

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
