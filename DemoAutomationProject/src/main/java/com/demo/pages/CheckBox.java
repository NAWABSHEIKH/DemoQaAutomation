package com.demo.pages;

import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class CheckBox {
	
	WebDriver driver;
	public CheckBox(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@title='Expand all']")
	WebElement expandAllBtn;
	
	@FindBy(xpath="//ol//li//span[@class='rct-checkbox']")
	List<WebElement> allCheckBox;
	
	@FindBy(xpath="//ol//li//span[@class='rct-title']")
	List<WebElement> allTextName;
	
	@FindBy(id="result")
	WebElement resultText;   // ✅ "You have selected :" message
	
	public void expandCheckBoxList() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", expandAllBtn);
		expandAllBtn.click();
	}
	
	public ArrayList<String> getAllCheckBoxName(){
		ArrayList<String> list = new ArrayList<>();
		for(WebElement all: allTextName) {
			list.add(all.getText().trim());
		}
		return list;	
	}
	
	// ✅ Click checkboxes by names (ignoring children if parent is selected)
	public void clickCheckBoxes(String... namesToSelect) {
	    Set<String> targets = new HashSet<>(Arrays.asList(namesToSelect));

	    for (int i = 0; i < allTextName.size(); i++) {
	        String checkboxName = allTextName.get(i).getText().trim();

	        if (targets.contains(checkboxName)) {
	            // ✅ If this is a parent and already clicked, skip children
	            if (isParent(checkboxName) && allCheckBox.get(i).isSelected()) {
	                removeChildrenFromTargets(checkboxName, targets);
	                continue;
	            }

	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", allCheckBox.get(i));

	            if (!allCheckBox.get(i).isSelected()) {
	                allCheckBox.get(i).click();
	            }

	            if (isParent(checkboxName)) {
	                removeChildrenFromTargets(checkboxName, targets);
	            }
	        }
	    }
	}

	// ✅ Helper: identify parent checkbox
	private boolean isParent(String checkboxName) {
	    return checkboxName.equalsIgnoreCase("Desktop") ||
	           checkboxName.equalsIgnoreCase("Documents") ||
	           checkboxName.equalsIgnoreCase("Downloads");
	}

	// ✅ Helper: remove children when parent is selected
	private void removeChildrenFromTargets(String parent, Set<String> targets) {
	    if (parent.equalsIgnoreCase("Desktop")) {
	        targets.remove("Notes");
	        targets.remove("Commands");
	    } else if (parent.equalsIgnoreCase("Documents")) {
	        targets.remove("WorkSpace");
	        targets.remove("Office");
	    } else if (parent.equalsIgnoreCase("Downloads")) {
	        targets.remove("Word File.doc");
	        targets.remove("Excel File.doc");
	    }
	}

	// ✅ Get actual result text after selecting checkboxes
	public String getSelectedResult() {
		return resultText.getText().trim();
	}
}
