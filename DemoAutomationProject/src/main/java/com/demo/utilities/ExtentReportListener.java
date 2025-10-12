package com.demo.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener implements ITestListener {

    private static ExtentReports extent;
    private static ExtentTest test;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static WebDriver driver; // we’ll set this from test classes

    @Override
    public void onStart(ITestContext context) {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportName = "ExtentReport_" + timeStamp + ".html";
        String reportPath = System.getProperty("user.dir") + "\\target\\Reports\\" + reportName;

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath);
        htmlReporter.config().setDocumentTitle("Automation Test Report");
        htmlReporter.config().setReportName("Project Execution Report");
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Project", "Demo Automation Project");
        extent.setSystemInfo("Tester", "MD NAWAB");
        extent.setSystemInfo("Environment", "QA");

        System.out.println("✅ Extent Report initialized at: " + reportPath);
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
        System.out.println("🚀 Test Started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed ✅");
        System.out.println("✅ Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().log(Status.FAIL, "❌ Test Failed: " + result.getThrowable());

        try {
            String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
            extentTest.get().addScreenCaptureFromPath(screenshotPath);
            System.out.println("📸 Screenshot attached for failed test: " + screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, "⚠️ Test Skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        System.out.println("📊 Extent Report generated successfully!");
    }

    // 🔹 Utility to capture screenshot on failure
    public String captureScreenshot(String testName) throws IOException {
        if (driver == null) {
            System.out.println("⚠️ WebDriver instance is null. Cannot take screenshot!");
            return "";
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = System.getProperty("user.dir") + "\\target\\Screenshots\\" + testName + "_" + timeStamp + ".png";

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File targetFile = new File(screenshotPath);
        org.openqa.selenium.io.FileHandler.createDir(new File(System.getProperty("user.dir") + "\\target\\Screenshots\\"));
        org.openqa.selenium.io.FileHandler.copy(srcFile, targetFile);

        return screenshotPath;
    }
}
