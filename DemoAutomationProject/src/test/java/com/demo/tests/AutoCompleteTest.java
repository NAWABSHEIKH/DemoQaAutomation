package com.demo.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.demo.base.BaseDriver;
import com.demo.pages.AutoCompletePage;
import com.demo.pages.RootPage;

public class AutoCompleteTest extends BaseDriver{
	
	@Test
	public void verifyColorInputBox() throws InterruptedException{
		RootPage rp=new RootPage(driver);
		rp.clickWidgetSection();
		
		AutoCompletePage act=new AutoCompletePage(driver);
		System.out.println("1. Title Varification : "+act.clickAndVerifyPage());
		
		List<String> colors=new ArrayList<>();
		colors.add("Blue");
		colors.add("green");
		act.sendMultipleOptionColor(colors);
		act.sendSingleOptionColor("Red");
		
	}

}
