package com.demo.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinksPage {
	
	WebDriver driver;
	public LinksPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//a[@id="simpleLink"]
	//a[@id="dynamicLink"]
	
	@FindBy(xpath="//a[@id=\"simpleLink\"]")
	WebElement simpleLink;
	
	@FindBy(xpath="//a[@id=\"dynamicLink\"]")
	WebElement dynamicLink;
	
	public void clickSimpleLink() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", simpleLink);
		simpleLink.click();
	}
	
	public String moveNextWindow(){
		
		
		
		Set<String> windowsHandles=driver.getWindowHandles();
		List<String> handlesList=new ArrayList<>(windowsHandles);
		
//		driver.switchTo().window(handlesList.get(0));
//	    System.out.println("First Page:"+ driver.getTitle());
	    
		
	    driver.switchTo().window(handlesList.get(1));
	   String titlePage= driver.getTitle();
	    System.out.println("Second Page:"+ driver.getTitle());   
		
		return titlePage;
	}
	
}
