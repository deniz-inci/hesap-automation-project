package com.hesapmakinesi.stepdefinitions;

import com.hesapmakinesi.pages.LoginPage;
import com.hesapmakinesi.utils.APIHelper;
import com.hesapmakinesi.utils.ConfigReader;
import com.hesapmakinesi.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    private LoginPage loginPage;

    @Given("Kullanıcı login ekranında")
    public void kullanici_login_ekraninda() {
        loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.navigateToLoginPage(); // Config'deki URL kullanılıyor
        loginPage.verifyLoginPageLoaded(); // Login ekranının tam olarak yüklendiğini doğrula
    }


    @When("Kullanıcı doğru bilgilerle giriş yapar")
    public void kullanici_dogru_bilgilerle_giris_yapar() {
        String username = ConfigReader.get("username"); // config.json'dan username çekiliyor
        String password = ConfigReader.get("password"); // config.json'dan password çekiliyor
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @Then("Kullanıcı giriş ekranını görür")
    public void kullanici_giris_ekranini_gorur() {
        loginPage.verifyLoginSuccess(); // Giriş başarılı mı kontrol ediliyor
    }



    private String accessToken; // API token'ı bir yerde saklamak için

    @When("Kullanıcı doğru bilgilerle API üzerinden giriş yapar")
    public void kullanici_dogru_bilgilerle_api_uzerinden_giris_yapar() {
        String username = ConfigReader.get("username");
        String password = ConfigReader.get("password");

        // API üzerinden login işlemi
        accessToken = APIHelper.loginViaAPI(username, password);
        if (accessToken == null || accessToken.isEmpty()) {
            throw new AssertionError("API login işlemi başarısız!");
        }
        System.out.println("API login başarılı. Access Token: " + accessToken);
    }

    @Then("Kullanıcı giriş işlemini başarılı olarak tamamlar")
    public void kullanici_giris_islemini_basarili_olarak_tamamlar() {
        if (accessToken == null || accessToken.isEmpty()) {
            throw new AssertionError("Access Token geçerli değil, login işlemi başarısız!");
        }
        System.out.println("Giriş işlemi başarılı olarak doğrulandı.");
    }



}
