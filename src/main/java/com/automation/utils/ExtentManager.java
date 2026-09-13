package com.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extentReports;

    private ExtentManager() {
    }

    public static synchronized ExtentReports getInstance() {

        if (extentReports == null) {

            String reportPath =
                    "test-output/ExtentReport.html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);

            sparkReporter.config()
                    .setDocumentTitle("Automation Test Report");

            sparkReporter.config()
                    .setReportName("Web & Mobile Automation");

            extentReports = new ExtentReports();

            extentReports.attachReporter(sparkReporter);

            extentReports.setSystemInfo(
                    "OS",
                    System.getProperty("os.name")
            );

            extentReports.setSystemInfo(
                    "Java",
                    System.getProperty("java.version")
            );
        }

        return extentReports;
    }
}