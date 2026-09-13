package com.automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    public static String captureScreenshot(
            WebDriver driver,
            String testName) {

        try {

            File source =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

            String fileName =
                    testName + "_" + System.currentTimeMillis() + ".png";

            // Actual location where screenshot is saved
            Path destination =
                    Path.of(
                            "test-output",
                            "screenshots",
                            fileName
                    );

            Files.createDirectories(
                    destination.getParent()
            );

            Files.copy(
                    source.toPath(),
                    destination,
                    StandardCopyOption.REPLACE_EXISTING
            );

            // Path relative to ExtentReport.html
            return Path.of(
                    "screenshots",
                    fileName
            ).toString().replace("\\", "/");

        } catch (Exception e) {

            throw new RuntimeException(
                    "Failed to capture screenshot",
                    e
            );
        }
    }
}