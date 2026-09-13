package com.automation.pages.web;

import com.automation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends BasePage {

    private WebDriver driver;

    private final By pageTitle=By.className("title");
    private final By backpackAddButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartButton = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
       return returnText(pageTitle);
    }

    public void addBackpackToCart() {
        click(backpackAddButton);
    }

    public void openCart() {
        click(cartButton);
    }
}
