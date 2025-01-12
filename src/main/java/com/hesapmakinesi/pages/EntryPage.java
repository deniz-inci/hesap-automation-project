package com.hesapmakinesi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EntryPage {

    WebDriver driver;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]")
    private WebElement openCalculatorButton;

    public EntryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOpenCalculatorButton() {
        openCalculatorButton.click();
    }

    public void verifyEntryPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(openCalculatorButton));
        } catch (TimeoutException e) {
            throw new RuntimeException("Entry ekranı yüklenemedi veya OPEN CALCULATOR butonu bulunamadı.", e);
        }
    }
}
