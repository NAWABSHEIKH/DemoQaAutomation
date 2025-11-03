package com.demo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.base.BaseDriver;
import com.demo.pages.ResizablePage;
import com.demo.pages.RootPage;
import com.demo.pages.SortablePage;

public class ResizableTest extends BaseDriver{
	
	@Test
	public void verifyResizablePage() {
		
		RootPage rp1=new RootPage(driver);
		rp1.clickInteractionBox();
		
		ResizablePage rp=new ResizablePage(driver);
		Assert.assertEquals(rp.clickAndVerifyResizablePage(), "Resizable");
		
		rp.resizeBoxWithRestriction();
		rp.resizeBox2();		
		
	}

}
