package com.hesapmakinesi.utils;

public class InterestCalculator {

    public static double calculateSimpleInterestViaAPI(String accessToken, double principal, double rate, double time) {
        try {
            // 1. Faiz oranını zamanla çarp: rate * time
            double intermediate = APIHelper.multiplyViaAPI(accessToken, rate, time);

            // 2. Sonucu ana para ile çarp: (rate * time) * principal
            double finalAmount = APIHelper.multiplyViaAPI(accessToken, intermediate, principal);

            return finalAmount;
        } catch (Exception e) {
            throw new RuntimeException("Faiz hesaplama API çağrısında hata: " + e.getMessage(), e);
        }
    }
}