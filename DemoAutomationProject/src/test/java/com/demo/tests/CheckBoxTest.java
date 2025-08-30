package com.demo.tests;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.demo.base.BaseDriver;
import com.demo.pages.CheckBox;
import com.demo.pages.RootPage;

public class CheckBoxTest extends BaseDriver {

	@Test
	public void verifyCheckBoxSelection() throws InterruptedException {
	    RootPage rp = new RootPage(driver);
	    rp.clickElementTab();
	    rp.ClickCheckBoxTab();

	    CheckBox cb = new CheckBox(driver);
	    cb.expandCheckBoxList();

	    ArrayList<String> allNames = cb.getAllCheckBoxName();
	    Assert.assertTrue(allNames.contains("Desktop"), "Desktop checkbox should be present");
	    Assert.assertTrue(allNames.contains("Angular"), "Angular checkbox should be present");

	    // ✅ Select multiple checkboxes
	    cb.clickCheckBoxes("Desktop", "Notes", "Commands", "Angular");

	    // ✅ Capture selected result text
	    String actualResult = cb.getSelectedResult();
	    System.out.println("Selected Checkboxes: " + actualResult);

	    // ✅ Desktop and Angular should be present
	    Assert.assertTrue(actualResult.contains("desktop"), "Result should contain Desktop");
	    Assert.assertTrue(actualResult.contains("angular"), "Result should contain Angular");

	    // ✅ Because Desktop is selected, Notes + Commands must also appear
	    Assert.assertTrue(actualResult.contains("notes"), "Notes should appear when Desktop is selected");
	    Assert.assertTrue(actualResult.contains("commands"), "Commands should appear when Desktop is selected");
	}

}
