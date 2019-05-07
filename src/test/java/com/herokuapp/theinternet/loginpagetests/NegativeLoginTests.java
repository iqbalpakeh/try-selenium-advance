package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class NegativeLoginTests extends TestUtilities {

    @Parameters({"username", "password", "expectedMessage"})
    @Test(priority = 1)
    public void negativeLoginTest(String username, String password, String expectedErrorMessage) {

        log.info("Starting negativeLoginTest");

        //---------------------------------------------------------------
        // EXECUTION
        //---------------------------------------------------------------

        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
        loginPage.negativeLogin(username, password);

        //---------------------------------------------------------------
        // VERIFICATIONS
        //---------------------------------------------------------------

        loginPage.waitForErrorMessage();
        String actualErrorMessage = loginPage.getErrorMessageText();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
                        + expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
    }

}
