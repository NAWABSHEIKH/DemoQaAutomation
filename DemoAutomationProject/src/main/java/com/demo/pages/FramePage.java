package com.demo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramePage {
	
	WebDriver driver;
	public FramePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()=\"Frames\"]")
	WebElement frameTab;
	
	@FindBy(xpath="//h1[text()=\"Frames\"]")
	WebElement validateTitlePage;
	
	@FindBy(xpath="//iframe[@id=\"frame1\"]")
	WebElement firstFrame;
	
	@FindBy(xpath="//h1[@id=\"sampleHeading\"]")
	WebElement validateFrameText;
	
	@FindBy(xpath="//iframe[@id=\"frame2\"]")
	WebElement secondFrame;
	
	public void scrollIntoViewJs(WebDriver driver,WebElement element){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public String moveInfoFirstFrame() {
		System.out.println("This is First Frame");

		scrollIntoViewJs(driver, firstFrame);
		driver.switchTo().frame(firstFrame);
		String frameText=validateFrameText.getText();
		driver.switchTo().defaultContent();
		return frameText;
	}
	
	public String moveInfoSecondFrame() {
		System.out.println("This is Second Frame");

		scrollIntoViewJs(driver, secondFrame);
		driver.switchTo().frame(secondFrame);
		String frameText=validateFrameText.getText();
		driver.switchTo().defaultContent();
		return frameText;
	}
	
	public void clickFrameTab() {

		scrollIntoViewJs(driver, frameTab);
		frameTab.click();
	}
	
	public String validateTitlePage() {

		scrollIntoViewJs(driver, validateTitlePage);
		return validateTitlePage.getText();
	}
	
	

}
