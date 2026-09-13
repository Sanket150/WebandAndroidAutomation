package com.automation.tests.web;

import com.automation.base.BaseWebTest;
import com.automation.driver.WebDriverFactory;
import com.automation.pages.web.InventoryPage;
import com.automation.pages.web.LoginPage;
import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseWebTest {

    @Test(groups ={"regression","smoke"})
    public void verifyValidLogin() {

        pages.get().loginPageReturn().loginPage(
                ConfigReader.get("web.username"),
                ConfigReader.get("web.password")
        );

        Assert.assertEquals(
                pages.get().inventoryPageReturn().getPageTitle(),
                "Products"
        );
    }

    @Test(groups ={"regression"})
    public void verifyInValidLogin() {

        pages.get().loginPageReturn().loginPage(
                ConfigReader.get("web.invaliduser"),
                ConfigReader.get("web.invalidpass")
        );

        Assert.assertTrue(
                pages.get().loginPageReturn().getErrorMessage().contains("Username and password do not match")
        );
    }



}