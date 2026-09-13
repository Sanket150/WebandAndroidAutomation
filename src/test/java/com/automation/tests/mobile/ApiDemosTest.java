package com.automation.tests.mobile;

import com.automation.base.BaseMobileTest;
import org.testng.annotations.Test;

public class ApiDemosTest extends BaseMobileTest {

    @Test
    public void verifyPreferenceNavigation() {

        pages.get()
                .apiDemosHomePageReturn()
                .clickPreference();
    }

    @Test
    public void verifyPreferenceDependencies() {

        pages.get()
                .apiDemosHomePageReturn()
                .clickPreference();

        pages.get()
                .preferencePageReturn()
                .clickPreferenceDependencies();
    }

    @Test
    public void verifyWifiSettings() {

        pages.get()
                .apiDemosHomePageReturn()
                .clickPreference();

        pages.get()
                .preferencePageReturn()
                .clickPreferenceDependencies();

        pages.get()
                .preferenceDependenciesPageReturn()
                .enableWifi();

        pages.get()
                .preferenceDependenciesPageReturn()
                .clickWifiSettings();
    }

    @Test
    public void verifyWifiNameEntry() {

        pages.get()
                .apiDemosHomePageReturn()
                .clickPreference();

        pages.get()
                .preferencePageReturn()
                .clickPreferenceDependencies();

        pages.get()
                .preferenceDependenciesPageReturn()
                .enableWifi();

        pages.get()
                .preferenceDependenciesPageReturn()
                .clickWifiSettings();

        pages.get()
                .wifiSettingsPageReturn()
                .enterWifiName("MyTestWifi");

        pages.get()
                .wifiSettingsPageReturn()
                .cancel();
    }
}