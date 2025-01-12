package com.hesapmakinesi.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class ConfigReader {

    private static JSONObject config;

    static {
        try {
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader("src/main/resources/config.json");
            config = (JSONObject) parser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Config dosyası okunamadı!");
        }
    }

    public static String get(String key) {
        return (String) config.get(key);
    }
}
