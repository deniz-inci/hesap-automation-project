package com.hesapmakinesi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hesapmakinesi.utils.ConfigReader; // Config'den URL'i alacak

import org.openqa.selenium.By; // By sınıfını ekliyor
import org.openqa.selenium.TimeoutException; // TimeoutException sınıfını ekliyor
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement usernameField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordField;

    @FindBy(xpath = "//div[@class='css-175oi2r r-1i6wzkk r-lrvibr r-1loqt21 r-1otgn73 r-1awozwy r-169ebfh r-z2wwpe r-h3s6tt r-1777fci r-tsynxw r-13qz1uu']")
    WebElement loginButton;

    public void navigateToLoginPage() {
        String url = ConfigReader.get("url"); // Config'deki URL kullanılıyor
        driver.get(url);
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void verifyLoginSuccess() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Duration ile zaman aşımı belirtiliyor
        try {
            // 2. ekranın belirgin bir elemanını kontrol edelim
            WebElement entryScreenElement = wait.until(
                    // OPEN CALCULATOR button
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]"))
            );
            if (!entryScreenElement.isDisplayed()) {
                throw new RuntimeException("Login işlemi başarısız!");
            }
        } catch (TimeoutException e) {
            throw new RuntimeException("Login işlemi başarısız! Belirtilen eleman zamanında yüklenmedi.", e);
        }
    }

    public void verifyLoginPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(usernameField));
            wait.until(ExpectedConditions.visibilityOf(passwordField));
            wait.until(ExpectedConditions.visibilityOf(loginButton));
        } catch (TimeoutException e) {
            throw new RuntimeException("Login ekranı tam olarak yüklenmedi.", e);
        }
    }



}
