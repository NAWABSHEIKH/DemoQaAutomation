package com.demo.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.base.BaseDriver;
import com.demo.pages.RootPage;
import com.demo.pages.TextBox;

public class TextBoxTest extends BaseDriver {
    
    @Test
    public void fillUserInfo() {
        RootPage rp = new RootPage(driver);
        rp.clickElementTab();
        rp.clickTextBox();

        TextBox tb = new TextBox(driver);

        String name = "Ajay";
        String email = "ajay@gmail.com";
        String address = "123RoadParkStreet";
        String permanentAdd = "321RoadParkCircus";

        tb.fillUserInfo(name, email, address, permanentAdd);
        tb.submitButton();

        // ✅ Explicit wait for result to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(tb.nameVerify));

        // ✅ Get result and assert field-wise
        List<String> userDetail = tb.getVerifyInfoUser();

        Assert.assertTrue(userDetail.get(0).contains(name), "Name mismatch!");
        Assert.assertTrue(userDetail.get(1).contains(email), "Email mismatch!");
        Assert.assertTrue(userDetail.get(2).contains(address), "Address mismatch!");
        Assert.assertTrue(userDetail.get(3).contains(permanentAdd), "Permanent Address mismatch!");
    
    
		for(String u:userDetail) {
	System.out.println(u);	
		}
		
    }
}
