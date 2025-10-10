package com.demo.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WidgetPage {
	
	WebDriver driver;
	public WidgetPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()=\"Accordian\"]")
	WebElement clickAccordianTab;
	
	@FindBy(xpath="//div[@id=\"accordianContainer\"]//h1")
	WebElement getAccordianPageTitle;
	
	
	@FindBy(xpath="//div[@id=\"section1Heading\"]")
	WebElement section1HeadingTab;
	
	@FindBy(xpath="//div[@id=\"section1Content\"]//p")
	WebElement section1ContentTab;
	
	
	@FindBy(xpath="//div[@id=\"section2Heading\"]")
	WebElement section2HeadingTab;
	
	@FindBy(xpath="//div[@id=\"section2Content\"]//p")
	List<WebElement> section2ContentTab;
	
	
	@FindBy(xpath="//div[@id=\"section3Heading\"]")
	WebElement section3HeadingTab;
	
	@FindBy(xpath="//div[@id=\"section3Content\"]//p")
	WebElement section3ContentTab;
	
	public String clickandVerifySection3Tab(){
		scrollIntoViewJS(driver,section3HeadingTab);
		section3HeadingTab.click();
		scrollIntoViewJS(driver,section3ContentTab);
		return section3ContentTab.getText();
	}
	
	
	
	
	public List<WebElement> clickandVerifySection2Tab() {
		scrollIntoViewJS(driver,section2HeadingTab);
		section2HeadingTab.click();
		
		List<WebElement> allPara=new ArrayList<>();
		allPara.addAll(section2ContentTab);
		
		return allPara;
	}
	
	
	
	public String clickAndVerifySection1Tab() {
		scrollIntoViewJS(driver,section1HeadingTab);
		section1HeadingTab.click();
		scrollIntoViewJS(driver,section1ContentTab);
		return section1ContentTab.getText();
	}
	
	
	public void scrollIntoViewJS(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public String clickAndAarifyAccordianPage() {
		scrollIntoViewJS(driver,clickAccordianTab);
		clickAccordianTab.click();
		scrollIntoViewJS(driver,getAccordianPageTitle);
		return getAccordianPageTitle.getText();
		
	}
	

}
