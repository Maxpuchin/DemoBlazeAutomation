package com.demoblaze.tests;

import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.LoginPage;
import com.demoblaze.utils.DriverManager;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest {
    private WebDriver browser;
    private HomePage mainPage;
    private LoginPage loginPage;
    private String USER = "1111120";
    private String PASS = "1111120";

    @BeforeMethod
    public void initialize() {
        browser = DriverManager.getDriver();
        browser.get("https://www.demoblaze.com/");
        mainPage = new HomePage(browser);
        loginPage = mainPage.clickLoginLink();
    }

    @Test
    public void testLoginSuccess() {
        loginPage.makeLogin(USER, PASS);

        Assert.assertTrue(mainPage.isUserLoggedIn(), "Авторизация не выполнена");
        Assert.assertEquals(mainPage.getLoggedInUsername(), "Welcome " + USER,
                "Приветствие пользователя отображается некорректно");
    }

    @Test
    public void testLoginWithEmptyFields() {
        loginPage.makeLogin("", "");

        Assert.assertTrue(loginPage.isPopupErrorMessageDisplayed("Please fill out Username and Password."),
                "Сообщение об ошибке не отображается.");
    }

    @Test
    public void testLoginWithInvalidPassword() {
        loginPage.makeLogin(USER, PASS + "wrong!");

        Assert.assertTrue(loginPage.isPopupErrorMessageDisplayed("Wrong password."),
                "Сообщение об ошибке не отображается.");
    }

    @AfterMethod
    public void cleanUp() {
        DriverManager.quitDriver();
    }
}
