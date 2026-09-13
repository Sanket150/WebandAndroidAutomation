package com.automation.driver;

import com.automation.utils.ConfigReader;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

    private static final ThreadLocal<WebDriver> driver =new ThreadLocal<>();
    public static void createDriver(String browser){
//        String browser= ConfigReader.get("browser");
        boolean headless=Boolean.parseBoolean(ConfigReader.get("headless"));
        boolean maximize=Boolean.parseBoolean(ConfigReader.get("maximize"));
        WebDriver webdriver;
         switch (browser.toLowerCase()){
             case "chrome":
                 ChromeOptions chromeOptions=new ChromeOptions();
                 if(headless){
                     chromeOptions.addArguments("--headless=new");
                     chromeOptions.addArguments("--no-sandbox");
                     chromeOptions.addArguments("--disable-dev-shm-usage");
                 }
                 webdriver=new ChromeDriver(chromeOptions);
                 break;
             case "firefox":
                 FirefoxOptions firefoxOptions=new FirefoxOptions();
                 if(headless){
                     firefoxOptions.addArguments("--headless=new");
                 }
                 webdriver=new FirefoxDriver(firefoxOptions);
                 break;
             case "edge":
                 EdgeOptions edgeOptions=new EdgeOptions();
                 if(headless){
                     edgeOptions.addArguments("--headless=new");
                 }
                 webdriver=new EdgeDriver(edgeOptions);
                 break;
             default:
                 throw new IllegalArgumentException(
                         "unsupported browser" + browser
                 );
         }
         driver.set(webdriver);
         if(maximize){
             driver.get().manage().window().maximize();
         }
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void quitDriver(){
        WebDriver webDriver = driver.get();

        if (webDriver != null) {
            webDriver.quit();
            driver.remove();
        }
    }
}
