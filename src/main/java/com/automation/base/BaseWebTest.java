package com.automation.base;

import com.automation.driver.WebDriverFactory;
import com.automation.pages.PageObjectManager;
import com.automation.utils.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class BaseWebTest {
    protected ThreadLocal<PageObjectManager> pages = new ThreadLocal<>();
    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setup(String browser){
        WebDriverFactory.createDriver(browser);
        WebDriverFactory.getDriver().get(ConfigReader.get("web.url"));
//        pages=new PageObjectManager(WebDriverFactory.getDriver());
        pages.set(
                new PageObjectManager(
                        WebDriverFactory.getDriver()
                )
        );

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
       WebDriverFactory.quitDriver();
        pages.remove();
    }
}
