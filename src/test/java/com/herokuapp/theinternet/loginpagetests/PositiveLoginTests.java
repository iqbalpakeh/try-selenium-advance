package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests extends TestUtilities {

    @Test
    public void positiveLoginTest() {

        log.info("Starting logIn test");

        //---------------------------------------------------------------
        // EXECUTION
        //---------------------------------------------------------------

        // Open welcome page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        takeScreenshot("WelcomePage opened");

        // Open login page
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
        takeScreenshot("LoginPage opened");

        // Add cookie
        Cookie ck = new Cookie("username", "tomsmith", "the-internet.herokuapp.com", "/", null);
        loginPage.setCookie(ck);

        // Execute login
        SecureAreaPage secureAreaPage = loginPage.login("tomsmith", "SuperSecretPassword!");
        takeScreenshot("SecuredPage opened");

        // Get cookies
        String username = secureAreaPage.getCookie("username");
        log.info("Username cookie: " + username);
        String session = secureAreaPage.getCookie("rack.session");
        log.info("Session cookie: " + session);

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
