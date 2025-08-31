package com.demo.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WebTable {
	
	@FindBy(xpath="//button[@id=\"addNewRecordButton\"]")
	WebElement addNewRecord;
	
	@FindBy(xpath="//input[@id=\"firstName\"]")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id=\"lastName\"]")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id=\"userEmail\"]")
	WebElement userEmail;
	
	@FindBy(xpath="//input[@id=\"age\"]")
	WebElement age;
	
	@FindBy(xpath="//input[@id=\"salary\"]")
	WebElement salary;
	
	@FindBy(xpath="//input[@id=\"department\"]")
	WebElement department;
	
	@FindBy(xpath="//button[@id=\"submit\"]")
	WebElement submitBtn;
	
	//input[@id="searchBox"]
	@FindBy(xpath="//input[@id=\"searchBox\"]")
	WebElement searchInputBox;	
	
	//span[@id="basic-addon2"]
	@FindBy(xpath="//span[@id=\"basic-addon2\"]")
	WebElement clickSearchButton;
	
	//div[@class="rt-tbody"]
	
//	@FindBy(xpath="//div[@class=\"rt-tr-group\"]")
//	List<WebElement> getUserInfoFromTable;	
	
	WebDriver driver;
	public WebTable(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddRecordBtn() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", addNewRecord);
	     addNewRecord.click();
	}
	
	public void setUserInfo(String firstName,String lastName,String email,int age,int salary,String department){
		
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.userEmail.sendKeys(email);
		this.salary.sendKeys(String.valueOf(salary));
		this.age.sendKeys(String.valueOf(age));
		this.department.sendKeys(department);
	}
	
	public void clickSubmit(){
		submitBtn.click();
	}
	
	public void setSearchUserInfo(String name){
		searchInputBox.sendKeys(name);
	}
	
	public void clickSearchInfoBtn() {
		clickSearchButton.click();
	}
	

}
