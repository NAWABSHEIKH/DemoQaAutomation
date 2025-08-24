package com.demo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.base.BaseDriver;
import com.demo.pages.RootPage;

public class ElementsTest extends BaseDriver {

	@Test
	public void clickElementTab() {
		
		RootPage rp=new RootPage(driver);
		rp.clickElementTab();
		rp.clickTextBox();
		
		
		 // ✅ Assertion: verify navigation is successful
        Assert.assertTrue(rp.isTextBoxPageDisplayed(), "Failed to navigate to Text Box page!");
	}
	
}
