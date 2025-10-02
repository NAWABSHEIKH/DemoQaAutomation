package com.demo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ButtonsPage {

	WebDriver driver;
	Actions act;
	public ButtonsPage(WebDriver driver) {
		this.driver=driver;
		act=new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@id=\"doubleClickBtn\"]")
	WebElement doubleClick;
	
	@FindBy(xpath="//button[@id=\"rightClickBtn\"]")
	WebElement rightClick;
	
	@FindBy(xpath="//button[text()=\"Click Me\"]")
	WebElement normalClick;
	
	
	@FindBy(xpath="//p[@id=\"doubleClickMessage\"]")
	WebElement doubleClickText;
	
	@FindBy(xpath="//p[@id=\"rightClickMessage\"]")
	WebElement rightClickText;
	
	@FindBy(xpath="//p[@id=\"dynamicClickMessage\"]")
	WebElement normalClickText;
	
	public String getDoubleClickText() {
		return doubleClickText.getText();
	}
	
	public String getRightClickText() {
		return rightClickText.getText();
	}
	
	public String getNormalClickText() {
		return normalClickText.getText();
	}
	
	public void doubleClick() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", doubleClick);
		act.doubleClick(doubleClick).perform();
	}
	
	public void rightClick() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", rightClick);
		act.contextClick(rightClick).perform();
	}
	public void normalClick() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", normalClick);
		act.click(normalClick).perform();
	}
	
	
	
}
