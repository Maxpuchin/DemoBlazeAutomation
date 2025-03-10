package com.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {
    @FindBy(id = "login2")
    private WebElement loginLink;
    @FindBy(id = "nameofuser")
    private WebElement userNameLabel;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickLoginLink() {
        loginLink.click();

        return new LoginPage(driver);
    }

    public String getLoggedInUsername() {
        wait.until(ExpectedConditions.visibilityOf(userNameLabel));

        return userNameLabel.getText();
    }

    public boolean isUserLoggedIn() {
        try {
            wait.until(ExpectedConditions.visibilityOf(userNameLabel));

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
