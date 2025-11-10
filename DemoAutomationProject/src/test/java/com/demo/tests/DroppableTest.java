package com.demo.tests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.base.BaseDriver;
import com.demo.pages.DroppablePage;
import com.demo.pages.RootPage;

public class DroppableTest extends BaseDriver{
	
	@Test
	public void verifyDroppableValidation() throws InterruptedException {
		RootPage rp1=new RootPage(driver);
		rp1.clickInteractionBox();
		
		DroppablePage dp=new DroppablePage(driver);
		Assert.assertEquals(dp.clickAndVerifyDroppableTitle(), "Droppable");
		Assert.assertEquals(dp.simpleDragAndDrop(), "#4682b4"); 
		
		 String actualColor = dp.clickAndVerifyAcceptableDragAndDrop();

		    // Expected green shade (you can inspect element manually in browser)
		    String expectedColor = "#3cb371";

		    Assert.assertEquals(actualColor, expectedColor, 
		        "❌ Droppable color did not change as expected when acceptable element was dragged!");
		    System.out.println("✅ Droppable color changed correctly to green!");
		    
		  ArrayList<String> valueColorAndText=dp.preventPropagationDragAndDrop();  
		  Assert.assertEquals(valueColorAndText.get(0), "Dropped!","Text didn't matched!");
		  Assert.assertEquals(valueColorAndText.get(1),"#8fbc8f" ,"Color after dropped didn't matched!");
		
		ArrayList<Boolean> revertPositionResult= dp.clickAndVerifyRevertableTab();
		Assert.assertTrue(revertPositionResult.get(0));
		Assert.assertFalse(revertPositionResult.get(1));
		  
	}

}
