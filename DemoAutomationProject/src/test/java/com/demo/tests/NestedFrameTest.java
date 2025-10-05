package com.demo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.base.BaseDriver;
import com.demo.pages.NestedFramePage;
import com.demo.pages.RootPage;

public class NestedFrameTest extends BaseDriver {

	@Test
	public static void verifyNestedFrameScenario() {
	    RootPage rp = new RootPage(driver);
	    rp.clickAlertFrameWindow();
	    
	    NestedFramePage npf = new NestedFramePage(driver);
	    npf.clickNestedFrameTab();

	    // Validate initial title
	    Assert.assertEquals(npf.validateNestedFrame(), "Nested Frames", 
	        "Initial Nested Frames title validation failed!");

	    // Validate title again after navigating through frames
	    String actualTitle = npf.moveIntoNestedFrameAndReturnTitle();
	    Assert.assertEquals(actualTitle, "Nested Frames", 
	        "Nested Frames title mismatch after returning from frames!");
	}


}
