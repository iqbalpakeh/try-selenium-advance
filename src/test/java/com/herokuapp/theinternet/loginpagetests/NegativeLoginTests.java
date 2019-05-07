package com.herokuapp.theinternet.loginpagetests;

import com.heroku.theinternet.base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.heroku.theinternet.pages.LoginPageObject;
import com.heroku.theinternet.pages.WelcomePageObject;

public class NegativeLoginTests extends TestUtilities {

    @Parameters({"username", "password", "expectedMessage"})
    @Test(priority = 1)
    public void negativeLoginTest(String username, String password, String expectedErrorMessage) {

        log.info("Starting negativeLoginTest");

        //---------------------------------------------------------------
        // EXECUTION
        //---------------------------------------------------------------

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();
        LoginPageObject loginPage = welcomePage.clickFormAuthenticationLink();
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
