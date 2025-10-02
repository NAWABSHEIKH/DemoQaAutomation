package com.demo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.base.BaseDriver;
import com.demo.pages.BrowserWindowPage;
import com.demo.pages.RootPage;

public class BrowserWindowTest extends BaseDriver{
	
	@Test
	public void verifyWindowTestCase() {
		RootPage rp = new RootPage(driver);
	    rp.clickAlertFrameWindow();
	    
	    BrowserWindowPage wp=new BrowserWindowPage(driver);
	    wp.clickBrowserWindowOption();
	    String differentWindowMessage=wp.clickWindowButtonPopUp();
	    String differentTabMessage=wp.clickTabButton();
	    String windowText=wp.clickMessageWindowButton();
	    System.out.println(windowText);
	    Assert.assertEquals(windowText,"Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.");
	    Assert.assertEquals(differentTabMessage, "This is a sample page","String is mismatch.");
	    Assert.assertEquals(differentWindowMessage, "This is a sample page","String is mismatch.");
	}

}
