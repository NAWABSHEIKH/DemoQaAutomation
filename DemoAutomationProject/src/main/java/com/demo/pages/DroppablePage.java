package com.demo.pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
	
	@FindBy(xpath="//a[@id=\"droppableExample-tab-preventPropogation\"]")
	WebElement clickPreventPropagationTab;
	
	@FindBy(xpath="//div[@id=\"notGreedyInnerDropBox\"]")
	WebElement getNotGreedyInnerDropBox;
	
	@FindBy(xpath="//div[@id=\"dragBox\"]")
	WebElement dragBox;
	
	@FindBy(xpath="//a[@id=\"droppableExample-tab-revertable\"]")
	WebElement revertableTab;

	@FindBy(xpath="//div[@id=\"revertable\"]")
	WebElement revertSrcBox;
	
	@FindBy(xpath="//div[@id=\"notRevertable\"]")
	WebElement nonRevertSrcBox;
	
	@FindBy(xpath="//div[@id='revertableDropContainer']//div[@id='droppable']")
	WebElement revertAndNonRevertDroppable;
	
	
	public ArrayList<Boolean> clickAndVerifyRevertableTab() throws InterruptedException {
		ArrayList<Boolean> revertPosition=new ArrayList<>();
		scrollIntoViewJS(driver,revertableTab);
		revertableTab.click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(revertSrcBox));
		
		Point revertInitialPosition=revertSrcBox.getLocation();
		int xCordinate=revertInitialPosition.getX();
		int yCordinate=revertInitialPosition.getY();
		System.out.println(xCordinate+"  "+yCordinate);
		
		Actions act=new Actions(driver);
		act.clickAndHold(revertSrcBox).perform();
		act.moveToElement(revertAndNonRevertDroppable).release().perform();
		
		Thread.sleep(3000);
		
		
		Point revertFinalPosition=revertSrcBox.getLocation();
		int x2Cordinate=revertFinalPosition.getX();
		int y2Cordinate=revertFinalPosition.getY();
		System.out.println(x2Cordinate+"  "+y2Cordinate);
		
		if(xCordinate==x2Cordinate && yCordinate==y2Cordinate) {
			System.out.println("true");
			revertPosition.add(true);
		}else {
			System.out.println("false");
			revertPosition.add(false);
		}
		
		System.out.println("======Revert working===========");
		
		Point revertInitialPosition2=nonRevertSrcBox.getLocation();
		int xCordinate3=revertInitialPosition2.getX();
		int yCordinate3=revertInitialPosition2.getY();
		System.out.println(xCordinate3+"  "+yCordinate3);
		
		Actions act2=new Actions(driver);
		act2.clickAndHold(nonRevertSrcBox).perform();
		act2.moveToElement(revertAndNonRevertDroppable).release().perform();
		
		Thread.sleep(3000);
		
		
		Point revertFinalPosition2=revertSrcBox.getLocation();
		int x2Cordinate4=revertFinalPosition2.getX();
		int y2Cordinate4=revertFinalPosition2.getY();
		System.out.println(x2Cordinate4+"  "+y2Cordinate4);
		
		if(xCordinate3==x2Cordinate4 && yCordinate3==y2Cordinate4) {
			System.out.println("true");
			revertPosition.add(true);
		}else {
			System.out.println("false");
			revertPosition.add(false);
		}
		
		return revertPosition;
	}
	
	
	public ArrayList<String> preventPropagationDragAndDrop(){
		ArrayList<String> listValue=new ArrayList<>();
		
		scrollIntoViewJS(driver,clickPreventPropagationTab);
		clickPreventPropagationTab.click();
		
//		scrollIntoViewJS(driver,dragBox);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(dragBox));
		
		String bgColor=getNotGreedyInnerDropBox.getCssValue("background-color");
		String beforeInnerBoxText=getNotGreedyInnerDropBox.findElement(By.xpath("p")).getText();
		System.out.println(beforeInnerBoxText);
		String beforeHexColor=Color.fromString(bgColor).asHex();
		System.out.println(beforeHexColor);
		
		Actions act=new Actions(driver);
		act.clickAndHold(dragBox).perform();
		
		act.moveToElement(getNotGreedyInnerDropBox).pause(Duration.ofSeconds(6)).perform();
		String bgColorAfter=getNotGreedyInnerDropBox.getCssValue("background-color");
		String afterHexColor=Color.fromString(bgColorAfter).asHex();
		System.out.println(afterHexColor);
		
		act.release().pause(3).perform();
		String afterInnerBoxText=getNotGreedyInnerDropBox.findElement(By.xpath("p")).getText();
		System.out.println(afterInnerBoxText);
		
		listValue.add(afterInnerBoxText);
		listValue.add(afterHexColor);
		
		return listValue;
		
	}
	
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
