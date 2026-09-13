package com.automation.listeners;

import com.automation.driver.MobileDriverFactory;
import com.automation.driver.WebDriverFactory;
import com.automation.utils.ExtentManager;
import com.automation.utils.ScreenshotUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final ExtentReports extent =
            ExtentManager.getInstance();

    private static final ThreadLocal<ExtentTest> extentTest =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test =
                extent.createTest(
                        result.getMethod().getMethodName()
                );

        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        extentTest.get()
                .pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        extentTest.get()
                .fail(result.getThrowable());

        WebDriver driver = getDriver();

        if (driver != null) {

            try {

                String screenshotPath =
                        ScreenshotUtils.captureScreenshot(
                                driver,
                                result.getMethod().getMethodName()
                        );

                extentTest.get()
                        .addScreenCaptureFromPath(
                                screenshotPath
                        );

            } catch (Exception e) {

                extentTest.get()
                        .warning(
                                "Unable to capture screenshot: "
                                        + e.getMessage()
                        );
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        extentTest.get()
                .skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

        extentTest.remove();
    }

    private WebDriver getDriver() {

        WebDriver webDriver =
                WebDriverFactory.getDriver();

        if (webDriver != null) {
            return webDriver;
        }

        if (MobileDriverFactory.getDriver() != null) {
            return MobileDriverFactory.getDriver();
        }

        return null;
    }
}