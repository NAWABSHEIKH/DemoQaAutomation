package com.demo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DroppablePage {

	WebDriver driver;
	public DroppablePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()=\"Droppable\"]")
	WebElement droppableOption;
	
	@FindBy(xpath="//h1[text()=\"Droppable\"]")
	WebElement droppableTitle;
	
	
	@FindBy(xpath="//a[@id=\"droppableExample-tab-simple\"]")
	WebElement simpleTab;
	
	@FindBy(xpath="//div[@id=\"draggable\"]")
	WebElement srcDraggable;
	
	@FindBy(xpath="//div[@id=\"droppable\"]")
	WebElement targetDraggable;
	
	@FindBy(xpath="//div[contains(@class,\"ui-state-highlight\")]")
	WebElement droppableContainerColor;
	
	public String simpleDragAndDrop() {
		scrollIntoViewJS(driver,simpleTab);
		boolean isSimpleTabavailable=simpleTab.isDisplayed();
		if(isSimpleTabavailable) {
			System.out.println("No need to click");
		}else {
			System.out.println("Click SimpleTab.");
		}
		
		Actions act=new Actions(driver);
		act.dragAndDrop(srcDraggable, targetDraggable).perform();
//		System.out.println("Drag and Drop is successful.");
		
		String bg_color=droppableContainerColor.getCssValue("background-color");
//		System.out.println(bg_color);
		Color color=Color.fromString(bg_color);
		String hexCode=color.asHex();
//		System.out.println(hexCode);
		return hexCode;
		
		
	}
	
	public void scrollIntoViewJS(WebDriver driver,WebElement ele){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", ele);
	}
	
	public String clickAndVerifyDroppableTitle() {
		scrollIntoViewJS(driver,droppableOption);
		droppableOption.click();
		scrollIntoViewJS(driver,droppableTitle);
		return droppableTitle.getText();
	}
	
	
}
