package com.demo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.base.BaseDriver;
import com.demo.pages.FramePage;
import com.demo.pages.RootPage;

public class FrameTest extends BaseDriver{
	
	@Test
	public void verifyFrameScenerio() {
		RootPage rp = new RootPage(driver);
	    rp.clickAlertFrameWindow();
	    
	    FramePage fp=new FramePage(driver);
	    fp.clickFrameTab();

	  Assert.assertEquals(fp.validateTitlePage(), "Frames","Text Not Matched");
	  Assert.assertEquals(fp.moveInfoFirstFrame(), "This is a sample page","Text Not Matched");
	  Assert.assertEquals(fp.moveInfoSecondFrame(), "This is a sample page","Text Not Matched");
	  
	  
		
	}

}
