package com.demo.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.base.BaseDriver;
import com.demo.pages.RootPage;
import com.demo.pages.SliderPage;

public class SliderTest extends BaseDriver {

	@Test
	public void verifySliderDragAndDropBy() throws InterruptedException {
		RootPage rp=new RootPage(driver);
		rp.clickWidgetSection();
		
		SliderPage sp=new SliderPage(driver);
		System.out.println("1. Title Page : "+sp.clickAndVerifyTitle());
		Assert.assertEquals(sp.clickAndVerifyTitle(), "Slider","Title Not Matched");
		String sliderRangeValue=sp.slideByDragAndDrop();
		String boxRangeValue=sp.getVisibleRangeFromBox();
		
		if(sliderRangeValue.equalsIgnoreCase(boxRangeValue)) {
			Assert.assertTrue(true);
			System.out.println("Slider Range Matched Successfully");
		}else {
			Assert.assertTrue(false);
			System.out.println("Wrong Range");
		}
	}
}
