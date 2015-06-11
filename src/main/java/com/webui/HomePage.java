package com.webui;

/**
 * Created by AnhonyChung on 5/11/2015.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;

    @FindBy(linkText = "Sign Out")
    private WebElement logOut = null;

    @FindBy(className = "welcome")
    private WebElement welcomeText = null;

    public HomePage(WebDriver d) throws Exception {
        this.driver = d;
        PageFactory.initElements(driver,this);
        try {
            (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("homePageMain")));
        } catch(TimeoutException e) {
            e.printStackTrace();
            throw (new IllegalStateException("This is not Health Homepage!"));
        }
    }

    public String getWelcomeText() {
        return welcomeText.getText();
    }

    public LoginPage logOut() throws Exception {
        logOut.click();
        return (new LoginPage(driver));
    }
}
