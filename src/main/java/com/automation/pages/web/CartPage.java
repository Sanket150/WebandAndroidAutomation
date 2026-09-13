package com.automation.pages.web;

import com.automation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By backpackItem =
            By.id("item_4_title_link");

    private final By removeBackpackButton =
            By.id("remove-sauce-labs-backpack");

    private final By cartItems =
            By.className("cart_item");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getBackpackName() {
        return returnText(backpackItem);
    }

    public void removeBackpack() {
        click(removeBackpackButton);
    }

    public boolean isCartEmpty() {
        return driver.findElements(cartItems).isEmpty();
    }
}