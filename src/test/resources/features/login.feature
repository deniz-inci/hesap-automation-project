@All @Login
Feature: Login Fonksiyonelliği
  Kullanıcının doğru bilgilerle giriş yapmasını test etmek için tasarlandı.

  Scenario: Başarılı Giriş
    Given Kullanıcı login ekranında
    When Kullanıcı doğru bilgilerle giriş yapar
    Then Kullanıcı giriş ekranını görür

  Scenario: API üzerinden başarılı login testi
    When Kullanıcı doğru bilgilerle API üzerinden giriş yapar
    Then Kullanıcı giriş işlemini başarılı olarak tamamlar
