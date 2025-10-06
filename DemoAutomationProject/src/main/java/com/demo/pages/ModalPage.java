package com.demo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModalPage {
	
	WebDriver driver;
	public ModalPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()=\"Modal Dialogs\"]")
	WebElement modalDialogTab;
	
	@FindBy(xpath="//h1[text()=\"Modal Dialogs\"]")
	WebElement validateModalTitle;
	
	@FindBy(xpath="//button[@id=\"showSmallModal\"]")
	WebElement clickSmallModal;
	
	@FindBy(xpath="//div[@class=\"modal-body\"]")
	WebElement getSmallModalText;
	
	@FindBy(xpath="//button[@id=\"closeSmallModal\"]")
	WebElement closeSmallModalPopup;
	
	@FindBy(xpath="//button[@id=\"showLargeModal\"]")
	WebElement clickLargeModal;
	
	@FindBy(xpath="//div[@class=\"modal-body\"]//p")
	WebElement getLargeModalText;
	
	@FindBy(xpath="//button[@id=\"closeLargeModal\"]")
	WebElement closeLargeModalPopup;
	
	public void scrollIntoViewJS(WebDriver driver,WebElement element){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
		
	}
	
	public void closeLargeModalBtn() {
		scrollIntoViewJS(driver,closeLargeModalPopup);
		closeLargeModalPopup.click();
	}
	
	public String getLargeModalText() {
		scrollIntoViewJS(driver,getLargeModalText);
		return getLargeModalText.getText();
	}
	
	public void clickLargeModal() {
		scrollIntoViewJS(driver,clickLargeModal);
		clickLargeModal.click();
	}
	
	public void closeSmallModalBtn() {
		scrollIntoViewJS(driver,closeSmallModalPopup);
		closeSmallModalPopup.click();
	}
	
	
	public String getSmallModalText() {
		scrollIntoViewJS(driver,getSmallModalText);
		return getSmallModalText.getText();
	}
	
	
	public void clickSmallDialogBtn() {
		scrollIntoViewJS(driver,clickSmallModal);
		clickSmallModal.click();
	}
	
	public String verifyModalPageTitie() {
		scrollIntoViewJS(driver,validateModalTitle);
		return validateModalTitle.getText();
	}
	
	public void clickModalTab() {
		scrollIntoViewJS(driver,modalDialogTab);
		modalDialogTab.click();
	}
	
	
	

}
