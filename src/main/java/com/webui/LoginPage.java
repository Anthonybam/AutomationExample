package com.webui;

/**
 *      Created by AnhonyChung on 5/11/2015.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement loginEdit = null;

    @FindBy(id = "password")
    private WebElement pwdEdit = null;

    @FindBy(className = "login-button")
    private WebElement loginButton = null;

    @FindBy(className = "etched-title1")
    private WebElement pageTitle = null;

    @FindBy(xpath = "/html/body/div[3]/div/form/span[2]")
    private WebElement versionLine = null;

    public LoginPage(WebDriver d) throws Exception {
        this.driver = d;
        PageFactory.initElements(driver,this);
        if (!pageTitle.getText().contentEquals("Health Center Login")) {
            throw (new IllegalStateException("This is not Health Login Page!"));
        }
    }

    public LoginPage setLoginID(String id) {
        loginEdit.sendKeys(id);
        return this;
    }

    public LoginPage setPassword(String password) {
        pwdEdit.sendKeys(password);
        return this;
    }

    public HomePage submit() throws Exception {
        loginButton.click();
        return (new HomePage(driver));
    }

    public LogonErrorPage submitExpectError() {
        loginButton.click();
        return (new LogonErrorPage(driver));
    }

    public HomePage loginRegularAccount(String userID,String password) throws Exception {
        setLoginID(userID);
        setPassword(password);
        return submit();
    }

    public String getVersionLine() {
        return versionLine.getText();
    }
}
