package com.automation.pages.mobile;

import com.automation.pages.BaseMobilePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PreferencePage extends BaseMobilePage {

    private final By preferenceDependencies =
            By.xpath("//android.widget.TextView[@text='Preference dependencies']");

    public PreferencePage(AndroidDriver driver) {
        super(driver);
    }

    public void clickPreferenceDependencies() {

        scrollToText("Preference dependencies");

        click(preferenceDependencies);
    }
}