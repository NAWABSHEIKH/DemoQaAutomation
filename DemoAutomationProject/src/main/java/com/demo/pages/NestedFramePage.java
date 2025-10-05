package com.demo.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFramePage {
	
	WebDriver driver;
	public NestedFramePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[text()=\"Nested Frames\"]")
	WebElement clickNestedFramesTab;
	
	@FindBy(xpath="//h1[text()=\"Nested Frames\"]")
	WebElement validatedNestedFramesPage;
	
	@FindBy(xpath="//iframe[@id=\"frame1\"]")
	WebElement parentFrames;
	
	@FindBy(tagName="body")
	WebElement bodyText;
	
	@FindBy(tagName="p")
	WebElement paraChildText;
	
	public String moveIntoNestedFrameAndReturnTitle() {	
	    driver.switchTo().frame(parentFrames);
	    System.out.println("First Comment: " + bodyText.getText());
	    
	    driver.switchTo().frame(0);
	    System.out.println("Child Frame Text: " + paraChildText.getText());
	    
	    driver.switchTo().parentFrame();
	    driver.switchTo().defaultContent();
	    
	    // Return page title text for assertion in test class
	    String title = validatedNestedFramesPage.getText();
	    System.out.println("Revalidated Page Title after switching back: " + title);
	    return title;
	}

	
	public String validateNestedFrame() {
		scrollIntoViewJs(driver, validatedNestedFramesPage);
		String validateTitle=validatedNestedFramesPage.getText();
		return validateTitle;
	}
	
	public void clickNestedFrameTab() {
		scrollIntoViewJs(driver, clickNestedFramesTab);
		clickNestedFramesTab.click();
	}
	
	public void scrollIntoViewJs(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
		
	}
	
	

}
