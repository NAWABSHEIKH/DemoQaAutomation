package com.demo.tests;

import org.testng.annotations.Test;

import com.demo.base.BaseDriver;
import com.demo.pages.DatePickerPage;
import com.demo.pages.RootPage;

public class DatePickerTest extends BaseDriver {
	
	@Test
	public void verifySelectDateFormat() {
		RootPage rp=new RootPage(driver);
		rp.clickWidgetSection();
		
		DatePickerPage dpp=new DatePickerPage(driver);
		System.out.println("1. "+dpp.clickAndVerifyDatePickerTab()); 
		
		dpp.selectDateFormat();
		dpp.selectDateAndTime();
	}

}
