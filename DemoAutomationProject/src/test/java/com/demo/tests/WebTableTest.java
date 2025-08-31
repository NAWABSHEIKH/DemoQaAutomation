package com.demo.tests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.base.BaseDriver;
import com.demo.pages.RootPage;
import com.demo.pages.WebTable;

public class WebTableTest extends BaseDriver{
	
	@Test(dataProvider = "dataUserInfo")
	public void addUserInfo(String fname,String lname,String email,int age,int salary,String department) throws InterruptedException {
		// Navigate to WebTable Button page via RootPage
        RootPage rp = new RootPage(driver);
        rp.clickElementTab();
        rp.clickWebTablePage();
        
        WebTable wt=new WebTable(driver);
        wt.clickAddRecordBtn();
        wt.setUserInfo(fname, lname, email, age,salary,department);
        wt.clickSubmit();
        
        wt.setSearchUserInfo(fname);
        wt.clickSearchInfoBtn();
        
        Thread.sleep(3000);
        
        
	}
	
	@DataProvider(name="dataUserInfo")
	public Object[][] setUserData(){
		Object data[][]={
				{"Nawab", "Pataudi", "mn@gmail.com", 100, 1000, "CSE"},
				{"Dawood", "Pataudi", "dnn@gmail.com", 10, 100000, "Data Analyst"},
		};
		return data;
	}
	
	
}
