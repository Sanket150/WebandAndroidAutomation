package com.automation.pages.mobile;

import com.automation.pages.BaseMobilePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PreferenceDependenciesPage extends BaseMobilePage {

    private final By wifiCheckbox =
            By.id("android:id/checkbox");

    private final By wifiSettings =
            By.xpath("//android.widget.TextView[@text='WiFi settings']");

    public PreferenceDependenciesPage(AndroidDriver driver) {
        super(driver);
    }

    public void enableWifi() {
        click(wifiCheckbox);
    }

    public void clickWifiSettings() {
        click(wifiSettings);
    }
}