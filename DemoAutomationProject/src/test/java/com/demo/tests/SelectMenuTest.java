package com.demo.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.base.BaseDriver;
import com.demo.pages.RootPage;
import com.demo.pages.SelectMenuPage;

public class SelectMenuTest extends BaseDriver{
	
	@Test
	public void verifyAllDifferentSelectMenuOption() {
		RootPage rp=new RootPage(driver);
		rp.clickWidgetSection();
		
		SelectMenuPage selectMenu=new SelectMenuPage(driver);
		String title=selectMenu.clickAndVerifySelectMenuPage();
		Assert.assertEquals(title, "Select Menu");
		
		String selectValue=selectMenu.selectValueAndGetValue("Group 2, opt");
		Assert.assertEquals(selectValue, "Group 2, option 1");
		
		String selectOne=selectMenu.selectOneAndGetValue("D");
		Assert.assertEquals(selectOne, "Dr.");
		
		String oldStyleValue=selectMenu.oldStyleSelectMenu();
		Assert.assertEquals(oldStyleValue, "Yellow");
		
		ArrayList<String> multipleValue=new ArrayList<>();
		multipleValue.add("Green");
		multipleValue.add("Blue");
		multipleValue.add("Red");
		
		List<String> getSelectedMutipleValue=selectMenu.multipleDropDownSelectionAndVerifcation(multipleValue);
		int returnValueSize=getSelectedMutipleValue.size();
		int sendVallueSize=multipleValue.size();
		Assert.assertEquals(returnValueSize, sendVallueSize);
		
		ArrayList<String> standardValue=new ArrayList<>();
		standardValue.add("Volvo");
		standardValue.add("Saab");
		standardValue.add("Audi");
		
		List<WebElement> returnValueMultiSelect=selectMenu.selectStandardMultiSelectAndVerifyResult(standardValue);
		ArrayList<String> returnStandardValue=new ArrayList<>();
		for(WebElement  ele:returnValueMultiSelect) {
			returnStandardValue.add(ele.getText());
		}
		
		Assert.assertTrue(standardValue.equals(returnStandardValue),"Not Matched");
		
	}

}
