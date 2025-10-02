package com.demo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.base.BaseDriver;
import com.demo.pages.AlertButtonPage; 
import com.demo.pages.RootPage;

public class AlertButtonTest extends BaseDriver{
	
	@Test
	public void verifyAlertButton(){
		RootPage rp = new RootPage(driver);
	    rp.clickAlertFrameWindow();
	    
	    AlertButtonPage alertButton=new AlertButtonPage(driver);
	    alertButton.clickAlertOption();
	    alertButton.normalAlertButton();
	    alertButton.clickTimerAlertButton();
	    String confirmMessage=alertButton.clickConfimationAlertWithMessage();
	    Assert.assertEquals(confirmMessage,"You selected Ok");
	    String passInPromtMessage="123345abc";
	    String promtMessage=alertButton.promptResultMessage(passInPromtMessage);
	    Assert.assertEquals(promtMessage,"You entered "+passInPromtMessage);
	    
	}

}
