package com.demo.pages;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object class for handling Radio Button functionality.
 * 
 * This class uses the Page Object Model (POM) design pattern
 * where locators and methods related to the "Radio Button" page
 * are grouped together.
 */
public class RadioButton {

    WebDriver driver;
    WebDriverWait wait; // Explicit wait to handle synchronization

    public RadioButton(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    // Page elements
    @FindBy(xpath = "//h1[text()='Radio Button']")
    WebElement centerText;

    @FindBy(xpath = "//div[@class='mb-3']")
    WebElement question;

    @FindBy(xpath = "//input[@id='impressiveRadio']")
    WebElement impressiveRadio;

    @FindBy(xpath = "//label[@for='impressiveRadio']")
    WebElement labelImpressiveRadio;

    @FindBy(xpath = "//input[@id='yesRadio']")
    WebElement yesRadio;

    @FindBy(xpath = "//label[@for='yesRadio']")
    WebElement labelYesRadio;

    @FindBy(xpath = "//p[@class='mt-3']")
    WebElement getClickedButton;

    /**
     * @return The title/header text of the page (e.g., "Radio Button").
     */
    public String getCenterText() {
        return centerText.getText();
    }

    /**
     * @return The question text shown above the radio buttons (e.g., "Do you like the site?").
     */
    public String getQuestion() {
        return question.getText();
    }

    /**
     * Clicks a radio button by its label text.
     * Uses label elements instead of inputs (inputs are hidden in HTML).
     *
     * @param btn Name of the button to click (e.g., "Yes", "Impressive").
     * @return The button text that was actually clicked.
     */
    public String clickBtn(String btn) {
        btn = btn.trim().toLowerCase(); // Normalize input for comparison

        // Scroll into view so element is interactable
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", impressiveRadio);

        if (btn.equals("impressive")) {
            wait.until(ExpectedConditions.elementToBeClickable(labelImpressiveRadio)).click();
            return "Impressive";
        } else if (btn.equals("yes")) {
            wait.until(ExpectedConditions.elementToBeClickable(labelYesRadio)).click();
            return "Yes";
        } else {
            throw new IllegalArgumentException("Invalid radio button option provided: " + btn);
        }
    }

    /**
     * Gets the confirmation message shown after clicking a radio button.
     *
     * @return Confirmation message text (e.g., "You have selected Impressive").
     *         Returns an empty string if not present.
     */
    public String getFinalClickedRadioBtn() {
        try {
            return getClickedButton.getText();
        } catch (Exception e) {
            return "";
        }
    }
}



//package com.demo.pages;
//
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class RadioButton {
//	
//	WebDriver driver;
//	public RadioButton(WebDriver driver) {
//		this.driver=driver;
//		PageFactory.initElements(driver, this);
//	}
//	
//	@FindBy(xpath="//h1[text()=\"Radio Button\"]")
//	WebElement centerText;
//	
//	@FindBy(xpath="//div[@class=\"mb-3\"]")
//	WebElement question;
//
//	@FindBy(xpath="//input[@id=\"impressiveRadio\"]")
//	WebElement impressiveRadio;
//	
//	@FindBy(xpath="//label[@for=\"impressiveRadio\"]")
//	WebElement labelImpressiveRadio;
//	
//	@FindBy(xpath="//input[@id=\"yesRadio\"]")
//	WebElement yesRadio;
//	
//	@FindBy(xpath="//label[@for=\"yesRadio\"]")
//	WebElement labelYesRadio;
//	
//	
//	@FindBy(xpath="//p[@class=\"mt-3\"]")
//	WebElement getClickedButton;
//	
//	public String getCenterText(){
//		String CenterText=centerText.getText();
//		return CenterText;	
//	}
//	
//	public String getQuetion(){
//		String Question=question.getText();
//		return Question;
//	}
//	
//	public String clickBtn(String btn) throws InterruptedException{
//		
//		String btnClick="";
//		 JavascriptExecutor js=(JavascriptExecutor)driver;
//		 js.executeScript("arguments[0].scrollIntoView()",impressiveRadio);
//		Thread.sleep(3000);
//		if(btn.equalsIgnoreCase(labelImpressiveRadio.getText())){
//			btnClick=labelImpressiveRadio.getText();
//			labelImpressiveRadio.click();
//		}else if(btn.equalsIgnoreCase(labelYesRadio.getText())) {
//			btnClick=labelYesRadio.getText();
//			labelYesRadio.click();
//		}else {
//			System.out.println("Button Not Matched");
//		}
//		
//		return btnClick;
//	}
//	
//	 public String getFinalClickedRadioBtn() {
//		 String getClickedText=getClickedButton.getText();
//		 return getClickedText;
//	 }
//
//}
