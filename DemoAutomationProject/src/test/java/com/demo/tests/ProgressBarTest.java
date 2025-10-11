package com.demo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.base.BaseDriver;
import com.demo.pages.ProgressBarPage;
import com.demo.pages.RootPage;

public class ProgressBarTest extends BaseDriver{
	
	@Test
	public void verifyStartStopWithRangeProgressBar() {
		
		RootPage rp=new RootPage(driver);
		rp.clickWidgetSection();
		
		ProgressBarPage pbp=new ProgressBarPage(driver);
		Assert.assertEquals(pbp.clickAndVerifyProgressBarTitle(), "Progress Bar","Title Not Matched");
		String passValueForStoppingProgressBar="50";
		String trackValue=pbp.trackAndStopProgressBar(passValueForStoppingProgressBar);
		Assert.assertEquals(trackValue, passValueForStoppingProgressBar,"Value didn't matched.");
	}

}
