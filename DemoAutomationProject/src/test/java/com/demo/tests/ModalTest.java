package com.demo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.base.BaseDriver;
import com.demo.pages.ModalPage;
import com.demo.pages.RootPage;

public class ModalTest extends BaseDriver {
	
	@Test
	public void verifyModelPageScenerio() {
		
		 RootPage rp = new RootPage(driver);
		 rp.clickAlertFrameWindow();
		 
		 ModalPage mp=new ModalPage(driver);
		 mp.clickModalTab();
		 Assert.assertEquals(mp.verifyModalPageTitie(), "Modal Dialogs");
		// System.out.println("1.Your Title Page --> "+mp.verifyModalPageTitie()); 
		 mp.clickSmallDialogBtn();
		 Assert.assertEquals(mp.getSmallModalText(), "This is a small modal. It has very less content");
		// System.out.println("2.Your Small Modal box Text --> "+ mp.getSmallModalText());
		 mp.closeSmallModalBtn();
		 mp.clickLargeModal();
		 Assert.assertEquals(mp.getLargeModalText(), "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
		// System.out.println("3.Your Large Modal box Text --> "+ mp.getLargeModalText());
		 mp.closeLargeModalBtn();
		 
		
		
	}

}
