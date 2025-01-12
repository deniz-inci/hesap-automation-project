@All @Entry
Feature: Entry Page Navigasyonu
  Kullanıcının giriş yaptıktan sonra hesap makinesi ekranına geçişini test etmek için tasarlandı.

  Scenario: Giriş ekranından hesap makinesi ekranına geçiş
    Given Kullanıcı giriş ekranındadır
    When Kullanıcı hesap makinesi ekranına geçmek için butona tıklar
    Then Kullanıcı hesap makinesi ekranını görür
