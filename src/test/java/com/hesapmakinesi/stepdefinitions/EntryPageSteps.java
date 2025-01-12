package com.hesapmakinesi.stepdefinitions;

import com.hesapmakinesi.pages.EntryPage;
import com.hesapmakinesi.pages.CalculatorPage;
import com.hesapmakinesi.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EntryPageSteps {

    EntryPage entryPage = new EntryPage(DriverManager.getDriver());
    CalculatorPage calculatorPage = new CalculatorPage(DriverManager.getDriver());

    @Given("Kullanıcı giriş ekranındadır")
    public void kullanici_giris_ekranindadir() {
        entryPage.verifyEntryPageLoaded(); // Entry ekranının yüklendiğini doğrula
    }

    @When("Kullanıcı hesap makinesi ekranına geçmek için butona tıklar")
    public void kullanici_hesap_makinesi_ekranina_gecmek_icin_butona_tiklar() {
        entryPage.clickOpenCalculatorButton();
    }

    @Then("Kullanıcı hesap makinesi ekranını görür")
    public void kullanici_hesap_makinesi_ekranini_gorur() {
        calculatorPage.verifyCalculatorPageLoaded(); // Calculator ekranının yüklendiğini doğrula
    }
}
