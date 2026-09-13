package com.automation.pages.mobile;

import com.automation.pages.BaseMobilePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ApiDemosHomePage extends BaseMobilePage {

    private final By preference =
            By.xpath("//android.widget.TextView[@text='Preference']");

    public ApiDemosHomePage(AndroidDriver driver) {
        super(driver);
    }

    public void clickPreference() {
        click(preference);
    }
}