package com.demo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.base.BaseDriver;
import com.demo.pages.DroppablePage;
import com.demo.pages.RootPage;

public class DroppableTest extends BaseDriver{
	
	@Test
	public void verifyDroppableValidation() {
		RootPage rp1=new RootPage(driver);
		rp1.clickInteractionBox();
		
		DroppablePage dp=new DroppablePage(driver);
		Assert.assertEquals(dp.clickAndVerifyDroppableTitle(), "Droppable");
		Assert.assertEquals(dp.simpleDragAndDrop(), "#4682b4"); 
		
	}

}
