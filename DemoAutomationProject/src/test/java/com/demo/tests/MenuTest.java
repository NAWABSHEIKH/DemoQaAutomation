package com.demo.tests;

import org.testng.annotations.Test;

import com.demo.base.BaseDriver;
import com.demo.pages.MenuPage;
import com.demo.pages.RootPage;

public class MenuTest extends BaseDriver{
	
	@Test
	public void verifyMenuPage() throws Exception {
		RootPage rp=new RootPage(driver);
		rp.clickWidgetSection();
		
		MenuPage mp=new MenuPage(driver);
		System.out.println("1. Your Title: "+mp.clickAndVerifyTitilePage());
		mp.hoverMainItemToSubItem();
		mp.captureFullPageScreenshot();
	}

}
