package com.demo.tests;


import java.util.ArrayList;
import java.util.List;

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
        
        Thread.sleep(5000);
        
     // retrieve row data
        List<String> actualData = wt.getSearchedRowData();

        // expected data in same column order as table
        List<String> expectedData = new ArrayList<>();
        expectedData.add(fname);
        expectedData.add(lname);
        expectedData.add(String.valueOf(age));
        expectedData.add(email);
        expectedData.add(String.valueOf(salary));
        expectedData.add(department);
        expectedData.add(""); // for Action column (empty text)

        // validation
        assert actualData.equals(expectedData) : 
            "❌ Data mismatch! Expected: " + expectedData + " but found: " + actualData;

        System.out.println("✅ Data matched successfully: " + actualData);
        
        
	}
	
	@DataProvider(name="dataUserInfo")
	public Object[][] setUserData(){
		Object data[][]={
				{"Nawab", "Pataudi", "mn@gmail.com", 99, 1000, "CSE"},
				{"Dawood", "Pataudi", "dnn@gmail.com", 10, 100000, "Data Analyst"},
		};
		return data;
	}
	
	
}
