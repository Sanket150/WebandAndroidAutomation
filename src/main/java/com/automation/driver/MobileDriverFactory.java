package com.automation.driver;

import com.automation.utils.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class MobileDriverFactory {

    private static final ThreadLocal<AndroidDriver> driver =
            new ThreadLocal<>();

    public static void createDriver() {

        String execution =
                ConfigReader.get("mobile.execution");

        if (execution.equalsIgnoreCase("local")) {

            createLocalDriver();

        } else if (execution.equalsIgnoreCase("browserstack")) {

            createBrowserStackDriver();

        } else {

            throw new IllegalArgumentException(
                    "Unsupported mobile execution mode: " + execution
            );
        }
    }

    private static void createLocalDriver() {

        try {

            UiAutomator2Options options =
                    new UiAutomator2Options();

            options.setPlatformName(
                    ConfigReader.get("platform.name")
            );

            options.setDeviceName(
                    ConfigReader.get("device.name")
            );

            options.setAutomationName(
                    ConfigReader.get("automation.name")
            );

            String appPath =
                    new File(
                            ConfigReader.get("app.path")
                    ).getAbsolutePath();

            options.setApp(appPath);

            URL appiumServerUrl =
                    new URL(
                            ConfigReader.get("appium.server.url")
                    );

            AndroidDriver androidDriver =
                    new AndroidDriver(
                            appiumServerUrl,
                            options
                    );

            driver.set(androidDriver);

        } catch (MalformedURLException e) {

            throw new RuntimeException(
                    "Invalid Appium server URL",
                    e
            );
        }
    }

    private static void createBrowserStackDriver() {

        try {

            UiAutomator2Options options =
                    new UiAutomator2Options();

            options.setPlatformName("Android");

            options.setDeviceName(
                    ConfigReader.get("browserstack.device")
            );

            options.setPlatformVersion(
                    ConfigReader.get("browserstack.os.version")
            );

            options.setAutomationName("UiAutomator2");

            options.setApp(
                    ConfigReader.get("browserstack.app")
            );

            options.setCapability(
                    "bstack:options",
                    Map.of(
                            "userName",
                            System.getenv(
                                    "BROWSERSTACK_USERNAME"
                            ),

                            "accessKey",
                            System.getenv(
                                    "BROWSERSTACK_ACCESS_KEY"
                            ),

                            "projectName",
                            ConfigReader.get(
                                    "browserstack.project"
                            ),

                            "buildName",
                            ConfigReader.get(
                                    "browserstack.build"
                            )
                    )
            );

            URL browserStackUrl =
                    new URL(
                            ConfigReader.get(
                                    "browserstack.url"
                            )
                    );

            AndroidDriver androidDriver =
                    new AndroidDriver(
                            browserStackUrl,
                            options
                    );

            driver.set(androidDriver);

        } catch (MalformedURLException e) {

            throw new RuntimeException(
                    "Invalid BrowserStack URL",
                    e
            );
        }
    }

    public static AndroidDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {

        AndroidDriver androidDriver =
                driver.get();

        if (androidDriver != null) {

            androidDriver.quit();
            driver.remove();
        }
    }
}