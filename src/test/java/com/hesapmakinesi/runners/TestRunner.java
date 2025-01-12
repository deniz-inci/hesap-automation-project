package com.hesapmakinesi.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Feature dosyalarının yolu
        glue = {"com.hesapmakinesi.stepdefinitions", "com.hesapmakinesi.utils"}, // Step Definitions ve Hooks'un bulunduğu paket
        plugin = {
                "pretty", // Daha okunabilir konsol çıktısı
                "html:target/cucumber-reports.html", // HTML raporu
                "json:target/cucumber.json" // JSON raporu
        },
        monochrome = true, // Konsol çıktısını daha okunabilir hale getirir
        tags = "@All" // Yalnızca belirtilen etiketlere sahip senaryoları çalıştırır
)
public class TestRunner {
}
