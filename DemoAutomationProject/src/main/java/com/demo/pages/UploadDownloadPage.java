package com.demo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadDownloadPage {
	
	WebDriver driver;
	public UploadDownloadPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//a[@id="downloadButton"]
	@FindBy(xpath="//a[@id=\"downloadButton\"]")
	WebElement downloadBtn; 
	
	//input[@id="uploadFile"]
	@FindBy(xpath="//input[@id=\"uploadFile\"]")
	WebElement uploadFile;
	
	@FindBy(xpath="//p[@id=\"uploadedFilePath\"]")
	WebElement uploadMessage;
	
	public void clickDownload() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView()", downloadBtn);
	    downloadBtn.click();
	}

	
	public String getUploadMessage() {
		return uploadMessage.getText();
	}
	
	public void uploadFile(String fileLocation){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", uploadFile);
		uploadFile.sendKeys(fileLocation);
	}

}
