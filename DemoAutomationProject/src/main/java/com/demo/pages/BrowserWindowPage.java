package com.demo.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserWindowPage {

    WebDriver driver;

    public BrowserWindowPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()=\"Browser Windows\"]")
    WebElement browserWindow;

    @FindBy(xpath = "//button[@id=\"tabButton\"]")
    WebElement tabButton;

    @FindBy(xpath = "//h1[@id=\"sampleHeading\"]")
    WebElement getNextTabHeading;

    @FindBy(xpath = "//button[@id=\"windowButton\"]")
    WebElement windowButton;

    @FindBy(xpath = "//button[@id=\"messageWindowButton\"]")
    WebElement messageWindowButton;

    // =========== Handle New Window Message ===========
    public String clickMessageWindowButton() {
        System.out.println("==========Clicking Message Window Button=======");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", messageWindowButton);
        messageWindowButton.click();

        // Store all window handles
        Set<String> windowID = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(windowID);

        // Switch to child message window
        driver.switchTo().window(windowList.get(1));

        String getMessageInfo = "";
        try {
            // Use Robot + Clipboard to capture the text
            Robot robot = new Robot();
            Thread.sleep(1000);

            // Select All (CTRL + A)
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            Thread.sleep(500);

            // Copy (CTRL + C)
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            Thread.sleep(500);

            // Fetch from Clipboard
            getMessageInfo = (String) Toolkit.getDefaultToolkit()
                    .getSystemClipboard().getData(DataFlavor.stringFlavor);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Message from New Window: " + getMessageInfo);

        driver.close(); // close child window
        driver.switchTo().window(windowList.get(0)); // switch back

        return getMessageInfo;
    }

    // =========== Handle New Window ===========
    public String clickWindowButtonPopUp() {
        System.out.println("==========Clicking Window Button=======");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", windowButton);
        windowButton.click();
        Set<String> windowID = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(windowID);
        driver.switchTo().window(windowList.get(1));
        String getNextTabHeadingInfo = getNextTabHeading.getText();
        driver.close();
        driver.switchTo().window(windowList.get(0));
        return getNextTabHeadingInfo;
    }

    // =========== Handle New Tab ===========
    public String clickTabButton() {
        System.out.println("==========Clicking Tab Button=======");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", tabButton);
        tabButton.click();
        Set<String> windowID = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(windowID);
        driver.switchTo().window(windowList.get(1));
        String getTabInfoDetail = getNextTabHeading.getText();
        driver.close();
        driver.switchTo().window(windowList.get(0));
        return getTabInfoDetail;
    }

    public void clickBrowserWindowOption() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", browserWindow);
        browserWindow.click();
    }

}
