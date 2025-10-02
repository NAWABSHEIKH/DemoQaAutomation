package com.demo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.base.BaseDriver;
import com.demo.pages.ButtonsPage;
import com.demo.pages.RootPage;
 
public class ButtonTest extends BaseDriver {
	@Test
	public void verifyButtonClickable() throws InterruptedException {
	    RootPage rp = new RootPage(driver);
	    rp.clickElementTab();
	    rp.clickButtonsTab();
	    
	    Thread.sleep(2000);
	    Assert.assertEquals(rp.buttonVerifyPage(), "Buttons");
	    
	    ButtonsPage bp=new ButtonsPage(driver);
	    bp.doubleClick();
	    
	    Thread.sleep(2000);
	    Assert.assertEquals(bp.getDoubleClickText(), "You have done a double click");
	    
	    
	    bp.rightClick();
	    Thread.sleep(2000);
	    Assert.assertEquals(bp.getRightClickText(), "You have done a right click");
	    
	    bp.normalClick();
	    Thread.sleep(2000);
	    Assert.assertEquals(bp.getNormalClickText(), "You have done a dynamic click");
	    
	    
	    
	}
}
