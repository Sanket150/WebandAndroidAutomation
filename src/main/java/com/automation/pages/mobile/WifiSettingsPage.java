package com.automation.pages.mobile;

import com.automation.pages.BaseMobilePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class WifiSettingsPage extends BaseMobilePage {

    private final By wifiInput =
            By.id("android:id/edit");

    private final By cancelButton =
            By.id("android:id/button2");

    public WifiSettingsPage(AndroidDriver driver) {
        super(driver);
    }

    public void enterWifiName(String wifiName) {
        type(wifiInput, wifiName);
    }

    public void cancel() {
        click(cancelButton);
    }
}