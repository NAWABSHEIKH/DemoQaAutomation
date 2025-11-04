package com.demo.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	 
	@FindBy(xpath="//a[@id=\"droppableExample-tab-accept\"]")
	WebElement acceptTab;
	
	@FindBy(xpath="//div[@id=\"acceptable\"]")
	WebElement srcAcceptableDrag;
	
	//p[text()="Dropped!"]
	@FindBy(xpath="//p[text()=\'Dropped!\']")
	WebElement childDroppableText;
	
	
	@FindBy(xpath="//div[@id='acceptDropContainer']//div[@id='droppable']")
	WebElement targetDroppableAccept;
	
	public String clickAndVerifyAcceptableDragAndDrop() throws InterruptedException {
		scrollIntoViewJS(driver,acceptTab);
		acceptTab.click();
		System.out.println("Click Successfull");
		scrollIntoViewJS(driver,acceptTab);
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOf(targetDroppableAccept));
	    wait.until(ExpectedConditions.visibilityOf(srcAcceptableDrag));

	    scrollIntoViewJS(driver, targetDroppableAccept);
	    scrollIntoViewJS(driver, srcAcceptableDrag);
		
		
		  Actions act = new Actions(driver);
		    act.clickAndHold(srcAcceptableDrag).perform();

		    // Move slightly towards target (hover)
		    act.moveToElement(targetDroppableAccept).pause(Duration.ofSeconds(1)).perform();

		    // Now fetch background color during hover
		    String bgColor = targetDroppableAccept.getCssValue("background-color");
		    String hexColor = Color.fromString(bgColor).asHex();
		    System.out.println("Background color during hover: " + hexColor);

		    // Release drag
		    act.release().perform();

		    return hexColor;
		
			
	}
	
	
	
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
