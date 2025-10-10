package com.demo.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.demo.base.BaseDriver;
import com.demo.pages.RootPage;
import com.demo.pages.WidgetPage;

public class WidgetTest extends BaseDriver {
	
	@Test
	public void verifyAccordianPage() {
		RootPage rp=new RootPage(driver);
		rp.clickWidgetSection();
		
		WidgetPage wp=new WidgetPage(driver);
		System.out.println("1.----->"+wp.clickAndAarifyAccordianPage());
		
		System.out.println("2.----->"+wp.clickAndVerifySection1Tab());
		
		List<WebElement> allParaOfSection2Accordian=wp.clickandVerifySection2Tab();
		
		System.out.println("----------3-------------");
		for(WebElement para:allParaOfSection2Accordian) {
			System.out.println(para.getText());
		}
		
		System.out.println("----------4-------------");
		System.out.println(wp.clickandVerifySection3Tab()); 
	}

}
