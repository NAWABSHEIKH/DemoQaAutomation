package com.demo.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutoCompletePage {

	WebDriver driver;
	public AutoCompletePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()=\"Auto Complete\"]")
	WebElement autoCompleteTab;
	
	@FindBy(xpath="//h1[text()=\"Auto Complete\"]")
	WebElement autoCompleteText;
	
	//div[contains(@class,"auto-complete__value-container--is-multi")]
	@FindBy(xpath="//input[@id=\"autoCompleteMultipleInput\"]")
    WebElement multipleOption;
	
	//input[@id="autoCompleteSingleInput"]
	@FindBy(xpath="//input[@id=\"autoCompleteSingleInput\"]")
    WebElement singleOption;
	
	public void scrollIntoViewJS(WebDriver driver,WebElement elemnent) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", elemnent);
	}
	
	public String clickAndVerifyPage(){
		scrollIntoViewJS(driver, autoCompleteTab);
		autoCompleteTab.click();
		scrollIntoViewJS(driver, autoCompleteText);
		return autoCompleteText.getText();
	}
	
	public void sendMultipleOptionColor(List<String> colors) throws InterruptedException {
		scrollIntoViewJS(driver, multipleOption);
		multipleOption.click();
		for(String color:colors) {
			multipleOption.sendKeys(color);
			multipleOption.sendKeys(Keys.ENTER);
		}	
	}
	
	public void sendSingleOptionColor(String color) throws InterruptedException {
		singleOption.click();
		singleOption.sendKeys(color);
		singleOption.sendKeys(Keys.ENTER);
		
	}
	
	
	
}
