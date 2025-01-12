package com.hesapmakinesi.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class APIHelper {

    private static final String BASE_URL = "https://catchylabs-api.testinium.com/api/v1";

    // Login via API
    public static String loginViaAPI(String username, String password) {
        RestAssured.baseURI = BASE_URL + "/login";

        Response response = given()
                .header("Content-Type", "application/json")
                .body("{ \"username\": \"" + username + "\", \"password\": \"" + password + "\" }")
                .post();

        if (response.statusCode() == 200) {
            return response.jsonPath().getString("access_token");
        } else {
            throw new RuntimeException("Login API failed with status code: " + response.statusCode());
        }
    }


    // Calculator Multiply via API
    public static double multiplyViaAPI(String accessToken, double number1, double number2) {
        RestAssured.baseURI = BASE_URL + "/calculators/multiplies";

        try {
            Response response = given()
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + accessToken)
                    .body("{ \"number1\": " + number1 + ", \"number2\": " + number2 + " }")
                    .post();

            // Loglama
            System.out.println("API Response Body: " + response.getBody().asString());
            System.out.println("API Response Status Code: " + response.getStatusCode());

            if (response.statusCode() == 200) {
                return response.jsonPath().getDouble("result");
            } else {
                throw new RuntimeException("Multiply API failed with status code: " + response.statusCode() +
                        ", body: " + response.body().asString());
            }
        } catch (Exception e) {
            throw new RuntimeException("API çağrısı sırasında bir hata oluştu: " + e.getMessage(), e);
        }
    }


    // Calculator Add via API
    public static int addViaAPI(String accessToken, int number1, int number2) {
        RestAssured.baseURI = BASE_URL + "/calculators/adds";

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + accessToken)
                .body("{ \"number1\": " + number1 + ", \"number2\": " + number2 + " }")
                .post();

        if (response.statusCode() == 200) {
            return response.jsonPath().getInt("result");
        } else {
            throw new RuntimeException("Add API failed with status code: " + response.statusCode());
        }
    }

    // Calculator Subtract via API
    public static int subtractViaAPI(String accessToken, int number1, int number2) {
        RestAssured.baseURI = BASE_URL + "/calculators/subtracts";

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + accessToken)
                .body("{ \"number1\": " + number1 + ", \"number2\": " + number2 + " }")
                .post();

        if (response.statusCode() == 200) {
            return response.jsonPath().getInt("result");
        } else {
            throw new RuntimeException("Subtract API failed with status code: " + response.statusCode());
        }
    }

    // Calculator Divide via API
    public static double divideViaAPI(String accessToken, int number1, int number2) {
        RestAssured.baseURI = BASE_URL + "/calculators/divides";

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + accessToken)
                .body("{ \"number1\": " + number1 + ", \"number2\": " + number2 + " }")
                .post();

        if (response.statusCode() == 200) {
            return response.jsonPath().getDouble("result");
        } else {
            throw new RuntimeException("Divide API failed with status code: " + response.statusCode());
        }
    }
}
