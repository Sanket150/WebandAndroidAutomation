package com.automation.utils;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream =
                     ConfigReader.class
                             .getClassLoader()
                             .getResourceAsStream("config.properties")) {

            if (inputStream == null) {
                throw new RuntimeException(
                        "config.properties not found"
                );
            }

            properties.load(inputStream);

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to load config.properties", e
            );
        }
    }

    public static String get(String key) {

        String systemProperty= System.getProperty(key);
        if(systemProperty!=null && !systemProperty.isBlank()){
            return systemProperty.trim();
        }
        String value = properties.getProperty(key);

        if (value == null) {
            throw new RuntimeException(
                    "Property not found: " + key
            );
        }

        return value.trim();
    }
}