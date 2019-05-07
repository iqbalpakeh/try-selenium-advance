package com.herokuapp.theinternet.loginpagetest;

import com.herokuapp.theinternet.base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPageObject;
import pages.SecureAreaPageObject;
import pages.WelcomePageObject;

public class PositiveLoginTests extends TestUtilities {

    @Test
    public void positiveLoginTest() {

        log.info("Starting logIn test");

        //---------------------------------------------------------------
        // EXECUTION
        //---------------------------------------------------------------

        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();
        LoginPageObject loginPageObject = welcomePageObject.clickFormAuthenticationLink();
        SecureAreaPageObject secureAreaPageObject = loginPageObject.login("tomsmith", "SuperSecretPassword!");

        //---------------------------------------------------------------
        // VERIFICATIONS
        //---------------------------------------------------------------

        // Check new url
        Assert.assertEquals(secureAreaPageObject.getCurrentUrl(), secureAreaPageObject.getPageUrl());

        // Check if logout button visible
        Assert.assertTrue(secureAreaPageObject.isLogoutButtonVisible(), "logOutButton is not visible.");

        // Check successful login message
        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = secureAreaPageObject.getSuccessMessageText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                        + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
    }

}
