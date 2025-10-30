package com.demo.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SortablePage {
	
	WebDriver driver;
	public SortablePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Sortable']")
	WebElement sortableTab;
	
	@FindBy(xpath="//h1[text()='Sortable']")
	WebElement sortableTitle;
	 
	@FindBy(xpath="//div[@id=\"demo-tabpane-list\"]//div[contains(@class,'list-group-item-action')][3]")
	WebElement thirdNumberSortableList;
	
	@FindBy(xpath="//div[@id=\"demo-tabpane-list\"]//div[contains(@class,'list-group-item-action')]")
	List<WebElement> allNumberSortableList;
	
	@FindBy(xpath="//a[@id=\"demo-tab-grid\"]")
	WebElement clickGridSection;
	
	
	@FindBy(xpath="//div[@class=\"create-grid\"]//div[contains(@class,'list-group-item-action')]")
	List<WebElement> allNumberSortableGrid;
	
	public ArrayList<String> dragFourChildFromGrid() {
		Actions act=new Actions(driver);
		WebElement src1=null;
		WebElement tar1=null;
		WebElement src2=null;
		WebElement tar2=null;
		
		ArrayList<String> beforeSorting=new ArrayList<>(); 
		ArrayList<String> afterSorting=new ArrayList<>(); 
		
System.out.println("=======Before Sorting=======");
		
		for(WebElement ele:allNumberSortableGrid) {
			System.out.println(ele.getText());
			beforeSorting.add(ele.getText());
		}
		
		
		for(WebElement ele:allNumberSortableGrid) {
			if(ele.getText().equalsIgnoreCase("One")) {
				src1=ele;
			}
			if(ele.getText().equalsIgnoreCase("Nine")) {
				tar1=ele;
			}
			
			if(ele.getText().equalsIgnoreCase("Four")) {
				src2=ele;
			}
			if(ele.getText().equalsIgnoreCase("Eight")) {
				tar2=ele;
			}
			
		}
		act.dragAndDrop(src1, tar1).build().perform();
		act.dragAndDrop(src2, tar2).build().perform();
		
		System.out.println("=======After Sorting=======");
		
		for(WebElement ele:allNumberSortableGrid) {
			System.out.println(ele.getText());
			afterSorting.add(ele.getText());
		}
		
		
		return afterSorting;
		
	}
	
	public void clickGridSectionOption() {
		scrollIntoViewJS(driver,clickGridSection);
		clickGridSection.click();
	}
	
	public ArrayList<String> sortSourceToTargetList() throws InterruptedException{
		scrollIntoViewJS(driver,thirdNumberSortableList);
		ArrayList<String> allSortableListName=new ArrayList<>();
		Actions act=new Actions(driver);
		for(WebElement ele:allNumberSortableList) {
			System.out.println(ele.getText());
			if(ele.getText().equalsIgnoreCase("Six")){ 
				act.dragAndDrop(thirdNumberSortableList, ele).build().perform();
				break;
			}
		}
		System.out.println("========After Sorting List=========");
		for(WebElement ele:allNumberSortableList) {
			allSortableListName.add(ele.getText());
		}
		
		return allSortableListName;

	}
	
	public void scrollIntoViewJS(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public String clickAndVerifySortablePage() {
		scrollIntoViewJS(driver,sortableTab);
		sortableTab.click();
		scrollIntoViewJS(driver,sortableTitle);
		return sortableTitle.getText();	
	}

}
