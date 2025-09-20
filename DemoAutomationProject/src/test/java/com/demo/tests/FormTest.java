package com.demo.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.demo.base.BaseDriver;
import com.demo.pages.FormPage;
import com.demo.pages.RootPage;

public class FormTest extends BaseDriver{
	
	@Test
	public void verifyUserDetails() throws InterruptedException {
		// Navigate to Dynamic Properties page via RootPage
		List<String> subjectName=new ArrayList<>();
		subjectName.add("Computer");
		subjectName.add("Physic");
		subjectName.add("Math");
		
        RootPage rp = new RootPage(driver);
        rp.clickFormTab();
        
        FormPage fp=new FormPage(driver);
        fp.clickPracticeForm();
        
        fp.setUserInfo("David", "Noah", "abc@gmail.com","1234567890");
        
        Thread.sleep(3000);
        
        fp.getGenderInfo();
        fp.setDateOfBirth();
        fp.selectSubject(subjectName);
        fp.selectHobbiesCheckBox();
        
     // ===== Upload part =====
        String fileLocation = "C:\\Users\\md786\\Downloads\\Hemant-Java-Dev.pdf";
        fp.uploadFile(fileLocation);
        
        fp.fillAddress("abcRoadPuneMaharastra");
        
        fp.setStateCity("NCR","Delhi");
        fp.submitBtn();
        
        Thread.sleep(3000);
        
        
	}

}
