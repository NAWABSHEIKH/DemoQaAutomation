package com.demo.tests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.base.BaseDriver;
import com.demo.pages.RootPage;
import com.demo.pages.SortablePage;

public class SortableTest extends BaseDriver{
	
	@Test
	public void verifyAllSortableAction() throws InterruptedException {
		
		RootPage rp=new RootPage(driver);
		rp.clickInteractionBox();
		
		SortablePage sp=new SortablePage(driver);
		Assert.assertEquals(sp.clickAndVerifySortablePage(), "Sortable");
		
		ArrayList<String> getAllCustomSortableValue=sp.sortSourceToTargetList();
		System.out.println("=====Custome List=======");
		System.out.println(getAllCustomSortableValue.get(2));
		Assert.assertNotEquals(getAllCustomSortableValue.get(2), "Three");
		
		sp.clickGridSectionOption();
		ArrayList<String> returnSortedGridValue=sp.dragFourChildFromGrid();
		Assert.assertEquals(returnSortedGridValue.get(0), "Two");
		Assert.assertEquals(returnSortedGridValue.get(returnSortedGridValue.size()-1), "One");
		
	}

}
