package com.demo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.base.BaseDriver;
import com.demo.pages.LinksPage;
import com.demo.pages.RootPage;

public class LinksTest extends BaseDriver {
	
	@Test
	public void verifyLinksMovable() throws InterruptedException {
		RootPage rp = new RootPage(driver);
	    rp.clickElementTab();
	    rp.clickLinksTab();
	    
	    LinksPage lp=new LinksPage(driver);
	    lp.clickSimpleLink();
	    Thread.sleep(3000);
	    Assert.assertEquals(lp.moveNextWindow(),"DEMOQA");
	}
		

}
