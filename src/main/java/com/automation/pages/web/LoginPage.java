package com.automation.pages.web;

import com.automation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    private WebDriver driver;

    private final By txt_username=By.id("user-name");
    private final By txt_password=By.id("password");
    private final By btn_login=By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void loginPage(String username, String password){
        type(txt_username,username);
        type(txt_password,password);
        click(btn_login);
    }

    public String getErrorMessage() {

        return returnText(errorMessage);
    }
}
