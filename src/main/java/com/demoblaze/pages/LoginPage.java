package com.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage extends BasePage {
    @FindBy(id = "loginusername")
    private WebElement usernameField;

    @FindBy(id = "loginpassword")
    private WebElement passwordField;

    @FindBy(css = "button[onclick='logIn()']")
    private WebElement loginButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage makeLogin(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        loginButton.click();

        return new HomePage(driver);
    }

    public boolean isPopupErrorMessageDisplayed(String expectedMessage) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent()); // Ждём появления алерта

            Alert alert = driver.switchTo().alert();
            String actualMessage = alert.getText();

            return actualMessage.equals(expectedMessage);
        } catch (Exception e) {
            return false;
        }
    }


}
