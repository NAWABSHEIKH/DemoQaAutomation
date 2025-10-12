package com.demo.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DatePickerPage {
	
	WebDriver driver;
	public DatePickerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()=\"Date Picker\"]")
	WebElement datePickerTab;
	
	@FindBy(xpath="//h1[text()=\"Date Picker\"]")
	WebElement datePickerTitle;
	
	@FindBy(xpath="//input[@id=\"datePickerMonthYearInput\"]")
	WebElement clickDateInputOption;

	@FindBy(xpath="//select[@class=\"react-datepicker__month-select\"]")
	WebElement selectMonthOption;
	
	@FindBy(xpath="//select[@class=\"react-datepicker__year-select\"]")
	WebElement selectYearOption;
	
	
	@FindBy(xpath="//input[@id=\"datePickerMonthYearInput\"]")
	WebElement getFullDateFormatText;
	
	@FindBy(xpath="//div[@class=\"react-datepicker__week\"]//div[contains(@class,\"react-datepicker__day\")]")
	List<WebElement> listOfDateOption;
	
	
	
	
	
	@FindBy(xpath="//input[@id=\"dateAndTimePickerInput\"]")
	WebElement dateAndTimePickerInput;
	
	@FindBy(xpath="//span[contains(@class,\"month-read-view--down-arrow\")]")
	WebElement clickMonthDownArrow;
	
	@FindBy(xpath="//div[@class=\"react-datepicker__month-dropdown\"]//div")
	List<WebElement> selectMonthFromDropDown;
	
	@FindBy(xpath="//span[contains(@class,\"year-read-view--down-arrow\")]")
	WebElement clickYearDownArrow;
	
	@FindBy(xpath="//div[@class=\"react-datepicker__year-dropdown\"]//div")
	List<WebElement> selectYearFromDropDown;
	
	@FindBy(xpath="//div[@class=\"react-datepicker__week\"]//div[contains(@class,\"react-datepicker__day\")]")
	List<WebElement> selectDateFromCalenderBox;
	
	@FindBy(xpath="//ul[@class=\"react-datepicker__time-list\"]//li")
	List<WebElement> listOfAllTime;
	
	
	public void selectDateAndTime(){
		scrollIntoViewJS(driver,dateAndTimePickerInput);
		dateAndTimePickerInput.click();
		scrollIntoViewJS(driver,clickMonthDownArrow);
		clickMonthDownArrow.click();
		
		List<WebElement> months=new ArrayList<>();
		months.addAll(selectMonthFromDropDown);
		
		for(WebElement month:months) {
			if(month.getText().equalsIgnoreCase("May")) {
				month.click();
				break;
			}
		}
		
		clickYearDownArrow.click();	
		List<WebElement> years=new ArrayList<>();
		years.addAll(selectYearFromDropDown);
		
		for(WebElement year:years) {
			if(year.getText().equalsIgnoreCase("2005")) {
				year.click();
				break;
			}
		}
		
		
		List<WebElement> dates=new ArrayList<>();
		dates.addAll(selectDateFromCalenderBox);
		
		for(WebElement date:dates) {
			if(date.getText().equalsIgnoreCase("10")) {
				date.click();
				break;
			}
		}
		
		List<WebElement> listOfAllTime=new ArrayList<>();
		dates.addAll(listOfAllTime);
		
		for(WebElement time:listOfAllTime) {
			if(time.getText().equalsIgnoreCase("03:30")) {
				time.click();
				break;
			}
		}
		
		System.out.println("2. You have selected : " + dateAndTimePickerInput.getAttribute("value"));
			
	}
	
	
	
	public void scrollIntoViewJS(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public String clickAndVerifyDatePickerTab(){
		scrollIntoViewJS(driver,datePickerTab);
		datePickerTab.click();
		scrollIntoViewJS(driver,datePickerTitle);
		return datePickerTitle.getText();
	}
	
	public void selectDateFormat() {
		scrollIntoViewJS(driver,clickDateInputOption);
		clickDateInputOption.click();
		
		scrollIntoViewJS(driver,selectMonthOption);
		Select month=new Select(selectMonthOption);
		month.selectByVisibleText("May");
		
		Select year=new Select(selectYearOption);
		year.selectByVisibleText("2005");
		
		List<WebElement> allDate=new ArrayList<>();
		allDate.addAll(listOfDateOption);
		
		for(WebElement date:allDate) {
			if(date.getText().equalsIgnoreCase("5")) {
				date.click();
				break;
			}
		}
		System.out.println("1. You have selected : " + getFullDateFormatText.getAttribute("value"));
		
		
	}
	
	
	

}
