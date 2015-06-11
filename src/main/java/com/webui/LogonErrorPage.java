package com.webui;

/**
 * Created by AnhonyChung on 5/14/2015.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogonErrorPage {
    private WebDriver driver;

    @FindBy(className = "appNotifyHeaderText")
    private WebElement pageHeader = null;

    @FindBy(className = "appNotifyLink")
    private WebElement notifyLink = null;


    public LogonErrorPage(WebDriver d) {
        this.driver = d;
        PageFactory.initElements(driver,this);

        if (!pageHeader.getText().contains("We were unable to log you on")) {
            throw (new IllegalStateException("This is not Logon Error Page!"));
        }
    }

    public String getPageHeader() {
        return pageHeader.getText();
    }

    public LoginPage clickTryAgain() throws Exception {
        notifyLink.click();
        return (new LoginPage(driver));
    }

}
