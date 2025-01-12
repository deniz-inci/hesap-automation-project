package com.hesapmakinesi.utils;

import com.hesapmakinesi.pages.CalculatorPage;
import com.hesapmakinesi.pages.EntryPage;
import com.hesapmakinesi.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        // Tarayıcı başlatılır
        DriverManager.getDriver().manage().window().maximize();
    }

    @Before("@Entry")
    public void setUpForEntryTests() {
        login();
        EntryPage entryPage = new EntryPage(DriverManager.getDriver());
        entryPage.verifyEntryPageLoaded(); // Giriş ekranı yüklendi mi kontrol ediliyor
    }

    @Before("@Calculator")
    public void setUpForCalculatorTests() {
        login();
        navigateToCalculator();
    }

    @After
    public void tearDown() {
        // Tarayıcı kapatılır
        DriverManager.closeDriver();
    }

    private void login() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.navigateToLoginPage();
        loginPage.verifyLoginPageLoaded();
        loginPage.enterUsername(ConfigReader.get("username"));
        loginPage.enterPassword(ConfigReader.get("password"));
        loginPage.clickLoginButton();
        loginPage.verifyLoginSuccess();
    }

    private void navigateToCalculator() {
        EntryPage entryPage = new EntryPage(DriverManager.getDriver());
        entryPage.verifyEntryPageLoaded();
        entryPage.clickOpenCalculatorButton();
        CalculatorPage calculatorPage = new CalculatorPage(DriverManager.getDriver());
        calculatorPage.verifyCalculatorPageLoaded();
    }
}
