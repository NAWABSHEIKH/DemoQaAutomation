package com.demo.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResizablePage {

    WebDriver driver;

    public ResizablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='resizableBoxWithRestriction']")
    WebElement resizeBox1;

    @FindBy(xpath = "//div[@id='resizable']")
    WebElement resizeBox2;

    @FindBy(xpath = "//span[text()='Resizable']")
    WebElement resizableTab;

    @FindBy(xpath = "//h1[text()='Resizable']")
    WebElement resizableTitle;

    public void scrollIntoViewJS(WebDriver driver, WebElement ele) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", ele);
    }

    /** 
     * Resize box with restriction and capture before/after offset
     */
    public void resizeBoxWithRestriction() {
        scrollIntoViewJS(driver, resizeBox1);

        // Capture before size and location
        Dimension beforeSize = resizeBox1.getSize();
        Point beforeLoc = resizeBox1.getLocation();

        WebElement handle = resizeBox1.findElement(By.xpath(".//span[contains(@class,'react-resizable-handle')]"));

        Actions act = new Actions(driver);
        act.clickAndHold(handle).moveByOffset(180, 200).release().perform();

        // Capture after size and location
        Dimension afterSize = resizeBox1.getSize();
        Point afterLoc = resizeBox1.getLocation();

        // Calculate offset changes
        int widthDiff = afterSize.getWidth() - beforeSize.getWidth();
        int heightDiff = afterSize.getHeight() - beforeSize.getHeight();
        int xOffset = afterLoc.getX() - beforeLoc.getX();
        int yOffset = afterLoc.getY() - beforeLoc.getY();

        System.out.println("=== Box 1 Resize Summary ===");
        System.out.println("Width increased by: " + widthDiff + " px");
        System.out.println("Height increased by: " + heightDiff + " px");
        System.out.println("X offset moved by: " + xOffset + " px");
        System.out.println("Y offset moved by: " + yOffset + " px");

        // Optional: Assertion or validation can happen in test class
    }

    /**
     * Resize box without restriction and capture before/after offset
     */
    public void resizeBox2() {
        scrollIntoViewJS(driver, resizeBox2);

        Dimension beforeSize = resizeBox2.getSize();
        Point beforeLoc = resizeBox2.getLocation();

        WebElement handle = resizeBox2.findElement(By.xpath(".//span[contains(@class,'react-resizable-handle')]"));

        Actions act = new Actions(driver);
        act.clickAndHold(handle).moveByOffset(300, 20).release().perform();

        Dimension afterSize = resizeBox2.getSize();
        Point afterLoc = resizeBox2.getLocation();

        int widthDiff = afterSize.getWidth() - beforeSize.getWidth();
        int heightDiff = afterSize.getHeight() - beforeSize.getHeight();
        int xOffset = afterLoc.getX() - beforeLoc.getX();
        int yOffset = afterLoc.getY() - beforeLoc.getY();

        System.out.println("=== Box 2 Resize Summary ===");
        System.out.println("Width increased by: " + widthDiff + " px");
        System.out.println("Height increased by: " + heightDiff + " px");
        System.out.println("X offset moved by: " + xOffset + " px");
        System.out.println("Y offset moved by: " + yOffset + " px");
    }

    public String clickAndVerifyResizablePage() {
        scrollIntoViewJS(driver, resizableTab);
        resizableTab.click();
        scrollIntoViewJS(driver, resizableTitle);
        return resizableTitle.getText();
    }
}


//package com.demo.pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class ResizablePage {
//
//	WebDriver driver;
//	public ResizablePage(WebDriver driver) {
//		this.driver=driver;
//		PageFactory.initElements(driver, this);
//	}
//	//div[@id="resizableBoxWithRestriction"]//span[contains(@class,"react-resizable-handle")]
//	@FindBy(xpath="//div[@id=\"resizableBoxWithRestriction\"]")
//	WebElement resizeBox1;
//	
//	//div[@id="resizable"]//span[contains(@class,"react-resizable-handle")]
//	@FindBy(xpath="//div[@id=\"resizable\"]")
//	WebElement resizeBox2;
//	
//	@FindBy(xpath="//span[text()=\"Resizable\"]")
//	WebElement resizableTab;
//	
//	@FindBy(xpath="//h1[text()=\"Resizable\"]")
//	WebElement resizableTitle;
//	
//	public void scrollIntoViewJS(WebDriver driver,WebElement ele) {
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView()", ele);
//	}
//	
//	public void resizeBoxWithRestriction() {
//		scrollIntoViewJS(driver,resizeBox1);
//		System.out.println(resizeBox1.getLocation());
//		WebElement smallArrow=resizeBox1.findElement(By.xpath(".//span[contains(@class,\"react-resizable-handle\")]"));
//		Actions act=new Actions(driver);
//		act.clickAndHold(smallArrow).moveByOffset(180, 200).perform();
//		System.out.println(resizeBox1.getLocation());
//	}
//	
//	public void resizeBox2() {
//		scrollIntoViewJS(driver,resizeBox2);
//		System.out.println(resizeBox2.getLocation());
//		WebElement smallArrow=resizeBox2.findElement(By.xpath(".//span[contains(@class,\"react-resizable-handle\")]"));
//		Actions act=new Actions(driver);
//		act.clickAndHold(smallArrow).moveByOffset(300, 20).perform();
//		System.out.println(resizeBox2.getLocation());
//		
//	}
//	
//	public String clickAndVerifyResizablePage() {
//		scrollIntoViewJS(driver,resizableTab);
//		resizableTab.click();
//		scrollIntoViewJS(driver,resizableTitle);
//		return resizableTitle.getText();
//	}
//	
//	
//}
