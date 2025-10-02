package com.demo.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertButtonPage {
	
	WebDriver driver;
	public AlertButtonPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()=\"Alerts\"]")
	WebElement  alertOption;
	
	@FindBy(xpath="//button[@id=\"alertButton\"]")
	WebElement normalAlert;
	
	@FindBy(xpath="//button[@id=\"timerAlertButton\"]")
	WebElement timerAlert;
	
	@FindBy(xpath="//button[@id=\"confirmButton\"]")
	WebElement confirmAlert;
	
	@FindBy(xpath="//span[@id=\"confirmResult\"]")
	WebElement confirmAlertMessage;
	
	@FindBy(xpath="//button[@id=\"promtButton\"]")
	WebElement promtAlert; 
	
	@FindBy(xpath="//span[@id=\"promptResult\"]")
	WebElement promtResultMessage; 
	
	public String  promptResultMessage(String yourPromt){
		String promtMessage="";
		
		promtAlert.click();
		driver.switchTo().alert().sendKeys(yourPromt);
		driver.switchTo().alert().accept();
	    promtMessage = promtResultMessage.getText();
		System.out.println(promtMessage);
		return promtMessage;
	}
	
	public String clickConfimationAlertWithMessage() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", confirmAlert);
		confirmAlert.click();
		driver.switchTo().alert().accept();
		String confirmMessage=confirmAlertMessage.getText();
		return confirmMessage;
		
		
	}
	
	public void clickTimerAlertButton() {
		timerAlert.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent()).accept();
		System.out.println("Waited for 5 second and accespted the alert box");
		
	}
	
	public void clickAlertOption() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", alertOption);
		alertOption.click();
	}
	
	public void normalAlertButton() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", normalAlert);
		normalAlert.click();
		driver.switchTo().alert().accept();
		System.out.println("Click ok Successful");
		
	}

}
