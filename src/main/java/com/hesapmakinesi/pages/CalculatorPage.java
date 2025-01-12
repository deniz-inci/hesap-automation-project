package com.hesapmakinesi.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage {

    WebDriver driver;

    // Text alanı
    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]")
    private WebElement resultText;

    // Butonlar
    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]")
    private WebElement buttonAC;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]")
    private WebElement buttonPlusMinus;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]")
    private WebElement buttonEmpty1;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]")
    private WebElement buttonDivide;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]")
    private WebElement button7;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[6]")
    private WebElement button8;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[7]")
    private WebElement button9;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[8]")
    private WebElement buttonMultiply;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[9]")
    private WebElement button4;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[10]")
    private WebElement button5;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[11]")
    private WebElement button6;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[12]")
    private WebElement buttonSubtract;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[13]")
    private WebElement button1;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[14]")
    private WebElement button2;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[15]")
    private WebElement button3;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[16]")
    private WebElement buttonAdd;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[17]")
    private WebElement button0;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[18]")
    private WebElement buttonEmpty2;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[19]")
    private WebElement buttonDecimal;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[20]")
    private WebElement buttonEquals;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Fonksiyonlar
    public void clickButtonAC() {
        buttonAC.click();
    }

    public void clickButtonPlusMinus() {
        buttonPlusMinus.click();
    }

    public void clickButtonDivide() {
        buttonDivide.click();
    }

    public void clickButtonMultiply() {
        buttonMultiply.click();
    }

    public void clickButtonSubtract() {
        buttonSubtract.click();
    }

    public void clickButtonAdd() {
        buttonAdd.click();
    }

    public void clickButtonEquals() {
        buttonEquals.click();
    }

    public void clickButtonDecimal() {
        buttonDecimal.click();
    }

    public void enterNumber(String number) {
        for (char digit : number.toCharArray()) {
            switch (digit) {
                case '0':
                    button0.click();
                    break;
                case '1':
                    button1.click();
                    break;
                case '2':
                    button2.click();
                    break;
                case '3':
                    button3.click();
                    break;
                case '4':
                    button4.click();
                    break;
                case '5':
                    button5.click();
                    break;
                case '6':
                    button6.click();
                    break;
                case '7':
                    button7.click();
                    break;
                case '8':
                    button8.click();
                    break;
                case '9':
                    button9.click();
                    break;
            }
        }
    }



    public String getResultText() {
        String rawResult = resultText.getText(); // Fetch the raw text
        System.out.println("Raw Result Text: " + rawResult); // Log the raw result

        // Ensure the string starts with "= " before attempting to clean it
        if (rawResult.startsWith("= ")) {
            rawResult = rawResult.substring(2).trim();
        }

        System.out.println("Cleaned Result Text: " + rawResult); // Log the cleaned result
        return rawResult;
    }




    public void verifyCalculatorPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // AC butonunun görünürlüğünü kontrol ediyoruz
            wait.until(ExpectedConditions.visibilityOf(buttonAC));
        } catch (TimeoutException e) {
            throw new RuntimeException("Calculator ekranı yüklü değil veya AC butonu bulunamadı.", e);
        }
    }


}
