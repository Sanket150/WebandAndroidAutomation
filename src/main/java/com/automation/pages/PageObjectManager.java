package com.automation.pages;

import com.automation.pages.web.CartPage;
import com.automation.pages.web.InventoryPage;
import com.automation.pages.web.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private final WebDriver driver;
    private LoginPage loginpage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;

    public PageObjectManager(WebDriver driver){
        this.driver=driver;
    }

    public LoginPage loginPageReturn(){
        loginpage=new LoginPage(driver);
        return loginpage;
    }

    public InventoryPage inventoryPageReturn(){
        inventoryPage=new InventoryPage(driver);
        return inventoryPage;
    }

    public CartPage cartPageReturn(){
        cartPage=new CartPage(driver);
        return cartPage;
    }
}
