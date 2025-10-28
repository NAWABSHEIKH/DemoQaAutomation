package com.demo.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SelectMenuPage {
	
	WebDriver driver;
	public SelectMenuPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[text()=\"Select Menu\"]")
	WebElement selectMenuTab;
	
	@FindBy(xpath="//h1[text()=\"Select Menu\"]")
	WebElement menuTitle;
	
	
	@FindBy(xpath="//input[@id=\"react-select-2-input\"]")
	WebElement selectValue;
	
//	Group 2, option 1  search this.
	//div[@class=" css-1uccc91-singleValue"]
	@FindBy(xpath="//div[@class=\" css-1uccc91-singleValue\"]")
	WebElement getSelectValue;
	
	
	@FindBy(xpath="//input[@id=\"react-select-3-input\"]")
	WebElement selectOne;
	
	
	@FindBy(xpath="//div[@id=\"selectOne\"]//div[@class=\" css-1uccc91-singleValue\"]")
	WebElement getSelectOneValue;
	
	
	@FindBy(xpath="//select[@id=\"oldSelectMenu\"]")
	WebElement oldStyleSelectMenu;
	
	
	@FindBy(xpath="//input[@id=\"react-select-4-input\"]")
	WebElement multipleDropDown;
	
	@FindBy(xpath="//div[@class=\"css-1rhbuit-multiValue\"]//div[@class=\"css-12jo7m5\"]")
	List<WebElement> getmultipleSelectedDropDownValue;
	
	@FindBy(xpath="//select[@name=\"cars\"]")
	WebElement selectStandardMultiSelect;
	
	public List<WebElement> selectStandardMultiSelectAndVerifyResult(List<String> values) {
		scrollIntoViewJs(driver,selectStandardMultiSelect);
		Select cars=new Select(selectStandardMultiSelect);
		for(String value:values) {
			cars.selectByVisibleText(value);
		}
		
	List<WebElement> returnCarsValue=cars.getAllSelectedOptions();
	return returnCarsValue;
		
	}
	
	
	
	
	public List<String> multipleDropDownSelectionAndVerifcation(List<String> values) {
		scrollIntoViewJs(driver,multipleDropDown);
		for(String value:values) {
			multipleDropDown.sendKeys(value);
			multipleDropDown.sendKeys(Keys.ENTER);
		}
		
		List<String> setFinalValue=new ArrayList<>();
		for(WebElement ele:getmultipleSelectedDropDownValue) {
			setFinalValue.add(ele.getText());
		}
		return setFinalValue;
		
	}
	
	public void scrollIntoViewJs(WebDriver driver,WebElement ele){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", ele);
	}
	
	public String oldStyleSelectMenu() {
		scrollIntoViewJs(driver,oldStyleSelectMenu);
		Select oldStyle=new Select(oldStyleSelectMenu);
		oldStyle.selectByVisibleText("Yellow");
		
		WebElement selectedValue=oldStyle. getFirstSelectedOption();
		return selectedValue.getText();
		
		
	}
	
	public String selectOneAndGetValue(String value) {
		scrollIntoViewJs(driver,selectOne);
		selectOne.sendKeys(value);
		selectOne.sendKeys(Keys.ENTER);
		return getSelectOneValue.getText();
	}
	
	public String clickAndVerifySelectMenuPage() {
		scrollIntoViewJs(driver,selectMenuTab);
		selectMenuTab.click();
		scrollIntoViewJs(driver,menuTitle);
		return menuTitle.getText();		
	}
	
	public String selectValueAndGetValue(String value) {
		scrollIntoViewJs(driver,selectValue);
		selectValue.sendKeys(value);
		selectValue.sendKeys(Keys.ENTER);
		return getSelectValue.getText();
	}
	
//	
//	@FindBy(xpath="")
//	WebElement xpath1;
	
	
	

}
