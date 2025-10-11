package com.demo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ContiguousSet;

public class ProgressBarPage {
	
	WebDriver driver;
	public ProgressBarPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()=\"Progress Bar\"]")
	WebElement progressBarTab;
	
	@FindBy(xpath="//div[@id=\"progressBarContainer\"]//h1")
	WebElement progressBarTitle;
	
	@FindBy(xpath="//button[@id=\"startStopButton\"]")
	WebElement startStopBtn;
	
	@FindBy(xpath="//div[@role=\"progressbar\"]")
	WebElement trackProgressBar;
	
	public void scrollIntoViewJS(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public String trackAndStopProgressBar(String passValueForStoppingProgressBar) {
		scrollIntoViewJS(driver, startStopBtn);
		startStopBtn.click();
		String trackValue;
		scrollIntoViewJS(driver, trackProgressBar);
		while(true) {
			trackValue=trackProgressBar.getAttribute("aria-valuenow");
			if(trackValue.equalsIgnoreCase(passValueForStoppingProgressBar)) {
				startStopBtn.click();
				break;
			}
		}
		System.out.println("Button is Stopped Now in range value : "+ trackValue);
		return trackValue;
	}
	
	public String clickAndVerifyProgressBarTitle() {
		scrollIntoViewJS(driver, progressBarTab);
		progressBarTab.click();
		scrollIntoViewJS(driver, progressBarTitle);
		return progressBarTitle.getText();
	}
	

}
