package com.automation.pages.mobile;

import io.appium.java_client.android.AndroidDriver;

public class MobilePageObjectManager {

    private final AndroidDriver driver;

    private ApiDemosHomePage apiDemosHomePage;
    private PreferencePage preferencePage;
    private PreferenceDependenciesPage preferenceDependenciesPage;
    private WifiSettingsPage wifiSettingsPage;

    public MobilePageObjectManager(AndroidDriver driver) {
        this.driver = driver;
    }

    public ApiDemosHomePage apiDemosHomePageReturn() {

        if (apiDemosHomePage == null) {
            apiDemosHomePage = new ApiDemosHomePage(driver);
        }

        return apiDemosHomePage;
    }

    public PreferencePage preferencePageReturn() {

        if (preferencePage == null) {
            preferencePage = new PreferencePage(driver);
        }

        return preferencePage;
    }

    public PreferenceDependenciesPage preferenceDependenciesPageReturn() {

        if (preferenceDependenciesPage == null) {
            preferenceDependenciesPage =
                    new PreferenceDependenciesPage(driver);
        }

        return preferenceDependenciesPage;
    }

    public WifiSettingsPage wifiSettingsPageReturn() {

        if (wifiSettingsPage == null) {
            wifiSettingsPage = new WifiSettingsPage(driver);
        }

        return wifiSettingsPage;
    }
}