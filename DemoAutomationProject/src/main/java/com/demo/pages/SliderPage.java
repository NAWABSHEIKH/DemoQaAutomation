package com.demo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SliderPage {
	
	WebDriver driver;
	 public SliderPage(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	 }
	 
	 @FindBy(xpath="//span[text()=\"Slider\"]")
	 WebElement sliderTab;
	 
	 @FindBy(xpath="//h1[text()=\"Slider\"]")
	 WebElement sliderTitle;
	 
	 @FindBy(xpath="//input[contains(@class,\"range-slider\")]")
	 WebElement horizontalSlider;
	 
	 @FindBy(xpath="//input[@id=\"sliderValue\"]")
	 WebElement rangeInInputBox;
	 
	 
	 public void scrollIntoViewJS(WebDriver driver,WebElement element) {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView()", element);
	 }
	 
	 public String getVisibleRangeFromBox() {
		 scrollIntoViewJS(driver,rangeInInputBox);
		 String displayRange=rangeInInputBox.getAttribute("value");
		 return displayRange;
	 }
	 
	 public String slideByDragAndDrop() {
		 Actions act=new Actions(driver);
		 scrollIntoViewJS(driver,horizontalSlider);
		 act.dragAndDropBy(horizontalSlider, 70, 0);
		 horizontalSlider.sendKeys(Keys.ARROW_RIGHT);
		 String currentRange=horizontalSlider.getAttribute("value");
		 System.out.println(currentRange);
		 return currentRange;
		 
	 }
	 
	 
	 
	 public String clickAndVerifyTitle(){
		 scrollIntoViewJS(driver,sliderTab);
		 sliderTab.click();
		 scrollIntoViewJS(driver,sliderTitle);
		 return sliderTitle.getText();
	 }
	 
	 
	 

}
