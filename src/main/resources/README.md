# Hesap Makinesi Automation Project

## 📜 Proje Hakkında
Bu proje, **Hesap Makinesi Modülü** için geliştirilmiş bir otomasyon test projesidir. Selenium 4 ve Cucumber BDD framework'ü kullanılarak oluşturulmuş olan bu proje, test süreçlerini daha kolay ve düzenli bir şekilde yönetmek için tasarlanmıştır. Proje kapsamında Page Object Model (POM) tasarım deseni uygulanmıştır.

## 🚀 Kullanılan Teknolojiler
- **Java** (JDK 23)
- **Selenium 4**
- **Cucumber (BDD)**
- **Cucumber HTML Reports**
- **Maven**
- **TestNG**
- **Git**

## 📁 Proje Yapısı
```
hesap-makinesi-automation/
├── .idea/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── hesapmakinesi/
│   │               ├── pages/
│   │               │   ├── CalculatorPage.java
│   │               │   ├── EntryPage.java
│   │               │   └── LoginPage.java
│   │               └── utils/
│   │                   ├── ConfigReader.java
│   │                   ├── DriverManager.java
│   │                   ├── Hooks.java
│   │                   └── Main.java
│   └── resources/
│       └── config.json
├── test/
│   ├── java/
│   │   └── com/
│   │       └── hesapmakinesi/
│   │           ├── runners/
│   │           │   └── TestRunner.java
│   │           ├── stepdefinitions/
│   │           │   ├── CalculatorSteps.java
│   │           │   ├── EntryPageSteps.java
│   │           │   └── LoginSteps.java
│   │           └── utils/
│   │               ├── APIHelper.java
│   │               └── InterestCalculator.java
│   └── resources/
│       └── features/
│           ├── calculator.feature
│           ├── entry.feature
│           ├── login.feature
│           └── config.json
├── target/
├── .gitignore
├── pom.xml
└── README.md
```

## ⚙️ Kurulum Talimatları

### 1. Projeyi Klonlama
```bash
git clone https://github.com/deniz-inci/hesap-automation-project.git
```

### 2. Maven Bağımlılıklarını İndirme
```bash
mvn clean install
```

### 3. ChromeDriver Yolunu Ayarlama
- `DriverManager.java` dosyasındaki `ConfigReader.get("chromedriverPath")` metodunun çalıştığından emin olun.
- `config.json` içerisinde "chromedriverPath" değeri doğru olmalıdır.

### 4. Test Uygulamasına Giriş (Login Credentials) Bilgilerini Ayarlama
- `config.json` içerisinde "username" ve "password" değerleri doğru olmalıdır.

### 5. Testleri Çalıştırma
#### Maven Kullanarak Test Çalıştırma
```bash
mvn test
```
#### IntelliJ IDEA Üzerinden Test Çalıştırma
- `TestRunner.java` dosyasına sağ tıklayın ve **Run 'TestRunner'** seçeneğini seçin.

## 🛠️ Sorun Giderme
- **Bağımlılık Sorunları:** Maven bağımlılıkları eksikse, IntelliJ IDEA'da sağ üst köşedeki **Maven** sekmesinden "Reload All Maven Projects" butonuna tıklayın.
- **ChromeDriver Sorunları:** ChromeDriver yolunun doğru ayarlandığından emin olun.
- **Kimlik Doğrulama Sorunları:** Eğer GitHub için kimlik doğrulama hatası alırsanız, Personal Access Token kullanarak giriş yapın.
