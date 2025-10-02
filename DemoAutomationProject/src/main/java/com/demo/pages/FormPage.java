package com.demo.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FormPage {
	
	WebDriver driver;
	
	public FormPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()=\"Practice Form\"]")
	WebElement practiceForm;
	
	@FindBy(xpath="//input[@id=\"firstName\"]")
	WebElement fname;
	
	@FindBy(xpath="//input[@id=\"lastName\"]")
	WebElement lname;
	
	@FindBy(xpath="//input[@id=\"userEmail\"]")
	WebElement email;
	
	@FindBy(xpath="//input[@id=\"userNumber\"]")
	WebElement number;
	
	@FindBy(xpath="//input[@name=\"gender\"]")
	List<WebElement> allGenderRadio;
	
	
	// ✅ Target labels instead of hidden inputs
	@FindBy(xpath="//label[contains(@for,'gender-radio')]")
	List<WebElement> allGenderLabels;
	
	@FindBy(xpath="//select[@class=\"react-datepicker__month-select\"]")
	WebElement month;
	
	@FindBy(xpath="//select[@class=\"react-datepicker__year-select\"]")
	WebElement year;
	
	@FindBy(xpath="//div[@class=\"react-datepicker__week\"]/div[contains(@class,\"react-datepicker__day\")]")
	List<WebElement> date;
	
	
	@FindBy(xpath="//input[@id=\"dateOfBirthInput\"]")
	WebElement dob;
	
	@FindBy(xpath="//input[@type=\"checkbox\"]/following-sibling::label")
	List<WebElement> hobbyCheckBox;
	
	@FindBy(xpath="//input[@id=\"uploadPicture\"]")
	WebElement uploadPicture;
	
	@FindBy(xpath="//textarea[@id=\"currentAddress\"]")
	WebElement currentAddress;
	
	@FindBy(xpath="//div[contains(text(),'Computer Science')]")
	WebElement computerScience;
	
	@FindBy(xpath="//input[@id=\"subjectsInput\"]")
	WebElement subjectContainer;
	
	@FindBy(xpath="//input[@id=\"react-select-3-input\"]")
	WebElement state;
	
	@FindBy(xpath="//input[@id=\"react-select-4-input\"]")
	WebElement city;
	
	@FindBy(xpath="//button[@id=\"submit\"]")
	WebElement submitBtn;
	
	@FindBy(xpath="//div[@id=\"example-modal-sizes-title-lg\"]")
	WebElement heading;
	
	@FindBy(xpath="//tbody//tr//td[2]")
	List<WebElement> values;
	
	public List<WebElement> getListOfValue(){
		List<WebElement> displayValues=new ArrayList<>();
		displayValues.addAll(values);
		return displayValues;
	}
	
	public String getSubmitHeading() {
		return heading.getText();
	}
	
	public void submitBtn(){
		submitBtn.click();
		System.out.println("You have finallly submitted the button");
	}
	
	public void setStateCity(String state,String city) throws InterruptedException {
		this.state.sendKeys(state);
		Thread.sleep(1000);
		this.state.sendKeys(Keys.ENTER);
		
		this.city.sendKeys(city);
		Thread.sleep(1000);
		this.city.sendKeys(Keys.ENTER);
		
	}
	
	public void selectSubject(List<String> subjects) throws InterruptedException {
		
		for(String subject:subjects) {
			subjectContainer.sendKeys(subject);
			Thread.sleep(2000);
			subjectContainer.sendKeys(Keys.ENTER); // select the highlighted option
			
		}
	}
	
	public void fillAddress(String address) {
		currentAddress.sendKeys(address);
	}
	
	public void uploadFile(String location) {
		uploadPicture.sendKeys(location);
	}
	
	public void selectHobbiesCheckBox() {
		List<WebElement> hobbies=new ArrayList<>();
		hobbies.addAll(hobbyCheckBox);
		
		for(WebElement hobby:hobbies) {
			String yourHobby=hobby.getText();
			if(yourHobby.equalsIgnoreCase("Music")||yourHobby.equalsIgnoreCase("Sports")) {
				hobby.click();
				System.out.println("You have clicked " + yourHobby); 
			}
			
			System.out.println(hobby.getText());
		}
	}
	
	
	public void setDateOfBirth() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView()", dob);
		dob.click();
		
		Select m=new Select(month);
		Select y=new Select(year);
		m.selectByVisibleText("May");
		y.selectByVisibleText("2006");
		
		List<WebElement> allDates=new ArrayList<>();
		allDates.addAll(date);
		
		for(WebElement date:allDates){
			String d=date.getText();
			if(d.equalsIgnoreCase("21")) {
				date.click();
				break;
			}
			
		}
	}
		
		
	public void getGenderInfo(){
			for(WebElement label : allGenderLabels) {
				String genderText = label.getText();
				System.out.println("Checking gender : " + genderText);
				
				if(genderText.equalsIgnoreCase("Other")) {   // You can pass "Male"/"Other"/"Female"
					label.click();   // ✅ clicks correct visible label
					System.out.println("You have clicked " + genderText);
					break;
				}
			}
		}
	
	
	public void clickPracticeForm() {
		practiceForm.click();
	}
	
	public void setUserInfo(String firstName,String lastName,String userEmail,String number) {
		fname.sendKeys(firstName);
		lname.sendKeys(lastName);
		email.sendKeys(userEmail);
		this.number.sendKeys(number);
	}
	
	

}
