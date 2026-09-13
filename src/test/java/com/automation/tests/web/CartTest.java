package com.automation.tests.web;

import com.automation.base.BaseWebTest;
import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseWebTest {

    @Test(groups = {"smoke", "regression"})
    public void verifyAddProductToCart() {
        pages.get().loginPageReturn().loginPage(
                ConfigReader.get("web.username"),
                ConfigReader.get("web.password")
        );

        // Add product
        pages.get().inventoryPageReturn()
                .addBackpackToCart();

        // Open cart
        pages.get().inventoryPageReturn()
                .openCart();

        // Verify product
        Assert.assertEquals(
                pages.get().cartPageReturn().getBackpackName(),
                "Sauce Labs Backpack"
        );
    }

    @Test(groups = {"regression"})
    public void verifyRemoveProductFromCart() {

        // Login
        pages.get().loginPageReturn().loginPage(
                ConfigReader.get("web.username"),
                ConfigReader.get("web.password")
        );

        // Add product
        pages.get().inventoryPageReturn()
                .addBackpackToCart();

        // Open cart
        pages.get().inventoryPageReturn()
                .openCart();

        // Remove product
        pages.get().cartPageReturn()
                .removeBackpack();

        // Verify cart is empty
        Assert.assertTrue(
                pages.get().cartPageReturn().isCartEmpty(),
                "Cart should be empty after removing the product"
        );
    }
}
