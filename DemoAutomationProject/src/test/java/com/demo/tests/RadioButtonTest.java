package com.demo.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.demo.base.BaseDriver;
import com.demo.pages.RadioButton;
import com.demo.pages.RootPage;

/**
 * Test class for verifying Radio Button functionality.
 *
 * This class uses TestNG framework to run assertions.
 * It follows best practices by keeping test logic separate
 * from Page Object logic.
 */
public class RadioButtonTest extends BaseDriver {

    // ✅ Test method using DataProvider
    @Test(dataProvider = "radioOptions")
    public void clickRadioBtn(String options) {
        // Navigate to Radio Button page via RootPage
        RootPage rp = new RootPage(driver);
        rp.clickElementTab();
        rp.clickRadioBtn();

        // Initialize RadioButton page object
        RadioButton rb = new RadioButton(driver);

        // Fetch page texts
        String centerText = rb.getCenterText();
        String question = rb.getQuestion();

        System.out.println("Page Header: " + centerText);
        System.out.println("Question: " + question);

        // Action: Click a radio button ("Impressive" in this example)
        String ans = rb.clickBtn(options);
        System.out.println("Clicked Button: " + ans);

        // Capture confirmation message after clicking
        String yourClickedBtn = rb.getFinalClickedRadioBtn();
        System.out.println("Displayed Confirmation: " + yourClickedBtn);

        // Validate results using clear assertion messages
        if (ans.equalsIgnoreCase("Yes")) {
            Assert.assertTrue(yourClickedBtn.contains("Yes"),
                    "Expected 'Yes' to be selected, but got: " + yourClickedBtn);
        } else if (ans.equalsIgnoreCase("Impressive")) {
            Assert.assertTrue(yourClickedBtn.contains("Impressive"),
                    "Expected 'Impressive' to be selected, but got: " + yourClickedBtn);
        } else {
            Assert.fail("No valid radio button was clicked.");
        }
    }
// ✅ DataProvider inside the same class
    @DataProvider(name = "radioOptions")
    public Object[][] getRadioOptions() {
    	return new Object[][] {
    		{"yes"},
    		{"impressive"}
    	};
    }
}


