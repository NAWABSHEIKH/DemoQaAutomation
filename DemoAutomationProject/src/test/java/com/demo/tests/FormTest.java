package com.demo.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
		
		String fname="David",lname="Noah",email="abc@gmail.com",number="1234567890",address="abcRoadPuneMaharastra",state="NCR",city="Delhi";
		
		
        RootPage rp = new RootPage(driver);
        rp.clickFormTab();
        
        FormPage fp=new FormPage(driver);
        fp.clickPracticeForm();
        
        fp.setUserInfo(fname,lname,email,number);
        
        Thread.sleep(3000);
        
        fp.getGenderInfo();
        fp.setDateOfBirth();
        fp.selectSubject(subjectName);
        fp.selectHobbiesCheckBox();
        
     // ===== Upload part =====
        String fileLocation = "C:\\Users\\md786\\Downloads\\Hemant-Java-Dev.pdf";
        fp.uploadFile(fileLocation);
        
        fp.fillAddress(address);
        
        fp.setStateCity(state,city);
        fp.submitBtn();
        
        Assert.assertEquals(fp.getSubmitHeading(), "Thanks for submitting the form");
        
        List<WebElement> values=fp.getListOfValue();
        String arr[]=new String[values.size()];
        int i=0;
        for(WebElement value:values) {
        	String validate=value.getText();
        	arr[i++]=validate;
        }
        
        System.out.println("===========Validate the Value after submit Form========");
        for(int j=0;j<arr.length;j++) {
        	System.out.println(arr[j]);
        }
        
        Assert.assertEquals(arr[0], "David Noah","User Name is Invalid");
        Assert.assertEquals(arr[1], "abc@gmail.com","User email is Invalid");
        Assert.assertEquals(arr[2], "Other","User gender is invalid");
        Assert.assertEquals(arr[3], "1234567890","User number is Invalid");
        Assert.assertEquals(arr[4], "21 May,2006","DOB is invalid");
        Assert.assertEquals(arr[5], "Computer Science, Physics, Maths","Subjects didn't matched");
        Assert.assertEquals(arr[6], "Sports, Music","Hobbies didn't matched.");
        Assert.assertEquals(arr[7], "Hemant-Java-Dev.pdf","PDF file didn't matched");
        Assert.assertEquals(arr[8], "abcRoadPuneMaharastra","Address didn't matched");
        Assert.assertEquals(arr[9], "NCR Delhi","State and City didn't matched");
        
        
        Thread.sleep(3000);
        
        
	}

}
