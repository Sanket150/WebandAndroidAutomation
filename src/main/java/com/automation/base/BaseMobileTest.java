package com.automation.base;

import com.automation.driver.MobileDriverFactory;
import com.automation.driver.WebDriverFactory;
import com.automation.pages.mobile.MobilePageObjectManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseMobileTest {
    protected ThreadLocal<MobilePageObjectManager> pages =
            new ThreadLocal<>();
    @BeforeMethod(alwaysRun = true)
    public void setup(){
        MobileDriverFactory.createDriver();
        pages.set(
                new MobilePageObjectManager(
                        MobileDriverFactory.getDriver()
                )
        );
    }

    @AfterMethod
    public void tearDown(){
        MobileDriverFactory.quitDriver();
        pages.remove();
    }
}
