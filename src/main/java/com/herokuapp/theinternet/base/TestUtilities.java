package com.herokuapp.theinternet.base;

import org.testng.annotations.DataProvider;

public class TestUtilities extends BaseTest {

    @DataProvider(name = "files")
    protected static Object[][] files() {
        return new Object[][]{
                {1, "index.html"},
                {2, "logo.png"},
                {3, "text.txt"}
        };
    }

    protected void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
