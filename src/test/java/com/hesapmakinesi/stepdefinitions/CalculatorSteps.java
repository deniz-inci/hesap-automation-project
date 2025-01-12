package com.hesapmakinesi.stepdefinitions;

import com.hesapmakinesi.pages.CalculatorPage;
import com.hesapmakinesi.utils.APIHelper;
import com.hesapmakinesi.utils.ConfigReader;
import com.hesapmakinesi.utils.DriverManager;
import com.hesapmakinesi.utils.InterestCalculator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CalculatorSteps {

    CalculatorPage calculatorPage = new CalculatorPage(DriverManager.getDriver());
    String accessToken;
    private double uiResult;
    private double apiResult;
    private double apiServiceResult;

    @Given("Kullanıcı hesap makinesi modülündedir")
    public void kullanici_hesap_makinesi_ekranini_gorur() {
        calculatorPage.verifyCalculatorPageLoaded(); // Calculator ekranının yüklendiğini doğrula
    }

    @When("Kullanıcı \"100\" yatırım tutarını, \"5\" faiz oranını girer ve hesaplama butonuna tıklar")
    public void kullanıcıHesaplamaFormülünüUygular() throws InterruptedException {
        calculatorPage.enterNumber(String.valueOf(1));
        calculatorPage.clickButtonDecimal();
        calculatorPage.enterNumber(String.valueOf(0));
        calculatorPage.enterNumber(String.valueOf(5));
        calculatorPage.clickButtonMultiply();
        calculatorPage.enterNumber(String.valueOf(100));
        calculatorPage.clickButtonEquals();
        Thread.sleep(2000); // Pause for 2 seconds
    }

    @And("Kullanıcı sonucu \"105\" olarak görür")
    public void kullanıcıUISonucunuGörür() {
        uiResult = Integer.parseInt(calculatorPage.getResultText());
        Assert.assertEquals("UI sonucu ile olması gereken tutar eşleşmiyor!", 105, uiResult, 0.01);
    }

    @And("Kullanıcı API üzerinden yatırım hesaplaması yapar")
    public void kullanıcıAPİÜzerindenYatırımHesaplamasıYapar() {

        String username = ConfigReader.get("username");
        String password = ConfigReader.get("password");

        accessToken = APIHelper.loginViaAPI(username, password);
        if (accessToken == null || accessToken.isEmpty()) {
            throw new AssertionError("API yatırım hesaplama işlemi başarısız!");
        }
        System.out.println("API yatırım hesaplama başarılı. Access Token: " + accessToken);

        double intermediate = APIHelper.multiplyViaAPI(accessToken, 0.05, 1); // 0.05 * 1 = 0.05
        apiResult = APIHelper.multiplyViaAPI(accessToken, intermediate, 100); // 0.05 * 100 = 105
    }

    @Then("Kullanıcı UI ve API sonuçlarını karşılaştırır")
    public void kullanıcıUIVeAPISonuçlarınıKarşılaştırır() {
        Assert.assertEquals("UI sonucu ile API sonucu eşleşmiyor!", apiResult, uiResult, 0.01);
    }


    @When("Kullanıcı API üzerinden faiz hesaplar")
    public void kullanici_api_uzerinden_faiz_hesaplar() {
        String username = ConfigReader.get("username");
        String password = ConfigReader.get("password");

        accessToken = APIHelper.loginViaAPI(username, password);
        // Gerekli parametreler
        double principal = 100.0;
        double rate = 0.05; // %5 faiz oranı
        double time = 1.0; // 1 yıl

        // API üzerinden faiz hesaplama
        apiServiceResult = InterestCalculator.calculateSimpleInterestViaAPI(accessToken, principal, rate, time);

        // Sonucu kaydet
        System.out.println("Faiz hesaplama sonucu: " + apiServiceResult);
    }

    @Then("Faiz hesaplama sonucu {string} olmalıdır")
    public void faiz_hesaplama_sonucu_105_olmalıdır(String expectedValue) {
        double expected = Double.parseDouble(expectedValue);
        Assert.assertEquals("Faiz hesaplama sonucu doğru değil", expected, apiServiceResult, 0.01); // Tolerans: 0.01
    }


}
