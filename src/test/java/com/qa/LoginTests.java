package com.qa;

/**
 * Created by AnhonyChung on 5/11/2015.
 */
import com.webui.HomePage;
import com.webui.LoginPage;
import com.webui.LogonErrorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import static org.testng.Assert.*;

public class LoginTests {
    private static final Logger LOG = Logger.getLogger(LoginTests.class);
    private final String pageURL = "https://svcqa1.bamlabs.com/bam/pages/logon.jsp";

    @Test(enabled = true)
    public void testLogin1() throws Exception {
        LOG.info("Starting testLogin1() test....");
        WebDriver driver = new FirefoxDriver();
        driver.get(pageURL);
        LoginPage lgPage = new LoginPage(driver);
        HomePage hPage = lgPage.loginRegularAccount(System.getProperty("loginID1"), System.getProperty("password1"));
        String[] txtArray = hPage.getWelcomeText().split("\n");
        hPage.logOut();
        Thread.sleep(100000);
        driver.quit();

        LOG.info("After closing web driver... Start data validation...");
        assertNotNull(txtArray);
        assertTrue(txtArray[0].contentEquals(System.getProperty("account1")),"Expect account name to be " + System.getProperty("account1") + ",but get " + txtArray[0]);
        LOG.info("End testLogin1() test....");
    }

    // Test Case ID: T01540
    @Test(enabled = true)
    public void testLoginNoIDPassword() throws Exception {
        LOG.info("Starting testLoginNoIDPassword(), Test Case ID: T01540...");
        WebDriver driver = new FirefoxDriver();
        driver.get(pageURL);
        LoginPage lgPage = new LoginPage(driver);
        LogonErrorPage errorPage = lgPage.submitExpectError();
        String errorText = errorPage.getPageHeader();
        assertNotNull(errorText,"Unable to get error text!");
        assertTrue(errorText.contentEquals("Sorry!\n" +
                "We were unable to log you on."),"Expect text: Sorry!\n" +
                "We were unable to log you on." + ",but get: " + errorText);

        driver.quit();
    }


    @Test(enabled = true)
    public void testLoginGetVersion() throws Exception {
        LOG.info("Starting testLoginGetVersion()....");
        WebDriver driver = new FirefoxDriver();
        driver.get(pageURL);
        String expectedLine = "Copyright © 2015 BAM Labs, Inc. All rights reserved. | Version 1.8.2 [1505052214] | Algo [22611]";
        LoginPage lgPage = new LoginPage(driver);
        String versionLine = lgPage.getVersionLine();
        driver.quit();
        System.out.println(versionLine);
        assertTrue(versionLine.contains(expectedLine),
                "Fail to verify version line info, get: " + versionLine
                + "Expect: " +  expectedLine);
    }
}
