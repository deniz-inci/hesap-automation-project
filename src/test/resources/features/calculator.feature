@All @Calculator
Feature: Hesap Makinesi Modülü

  @FaizHesaplama
  Scenario: Kullanıcı yatırım hesaplama işlemini manuel tamamlar ve API sonucu ile karşılaştırır
    Given Kullanıcı hesap makinesi modülündedir
    When Kullanıcı "100" yatırım tutarını, "5" faiz oranını girer ve hesaplama butonuna tıklar
    And Kullanıcı sonucu "105" olarak görür
    And Kullanıcı API üzerinden yatırım hesaplaması yapar
    Then Kullanıcı UI ve API sonuçlarını karşılaştırır

  @FaizHesaplama
  Scenario: Kullanıcı API üzerinden faiz hesaplar (Mikroservis: InterestCalculator)
    When Kullanıcı API üzerinden faiz hesaplar
    Then Faiz hesaplama sonucu "105.0" olmalıdır
