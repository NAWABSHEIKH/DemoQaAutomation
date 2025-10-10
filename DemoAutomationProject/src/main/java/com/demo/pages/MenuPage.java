package com.demo.pages;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.idealized.Network.UserAgent;
import org.openqa.selenium.devtools.v125.page.Page;
import org.openqa.selenium.devtools.v125.page.model.Screenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class MenuPage {
	
	WebDriver driver;
	public MenuPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	 
	@FindBy(xpath="//span[text()=\"Menu\"]")
	WebElement menuTab; 
	
	@FindBy(xpath="//h1[text()=\"Menu\"]")
	WebElement menuTitle; 
	
	@FindBy(xpath="//a[text()=\"Main Item 2\"]")
	WebElement MainItem2;
	
	@FindBy(xpath="//a[text()=\"SUB SUB LIST »\"]")
	WebElement SubItem2;
	
	@FindBy(xpath="//div[@class=\"col-12 mt-4 col-md-6\"]")
	WebElement entireMenuSection;
	
	
	public void scrollIntoViewJS(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public void captureFullPageScreenshot() throws Exception {
	    ru.yandex.qatools.ashot.Screenshot screenshot = new AShot()
	            .shootingStrategy(ShootingStrategies.viewportPasting(1000))
	            .takeScreenshot(driver);
	    ImageIO.write((RenderedImage) screenshot.getImage(), "PNG", new File(System.getProperty("user.dir") + "\\target\\FullPageScreenshot.png"));
	    System.out.println("✅ Full-page screenshot saved successfully using AShot!");
	}
	
//	public void captureScreenShot() throws InterruptedException {
//		Thread.sleep(3000);
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		File srcfile=ts.getScreenshotAs(OutputType.FILE);
//		File tarfile=new File(System.getProperty("user.dir")+"\\target"+"\\MenuPageSS.jpg");
//		srcfile.renameTo(tarfile);
//		
//	}
	
	public void hoverMainItemToSubItem() throws InterruptedException, IOException {
	    Actions act = new Actions(driver);
	    scrollIntoViewJS(driver, MainItem2);

	    // Step 1: Hover to show sub-menu
	    act.moveToElement(MainItem2).perform();
	    Thread.sleep(1000); // allow hover menu to appear

	    act.moveToElement(SubItem2).perform();
	    Thread.sleep(1000); // ensure sub menu fully visible

	    // Step 2: Take screenshot of entire visible page (not just one element)
	    ru.yandex.qatools.ashot.Screenshot hoverShot = new AShot()
	            .shootingStrategy(ShootingStrategies.simple())  // simple = keeps hover state intact
	            .shootingStrategy(ShootingStrategies.viewportPasting(1000))
	            .takeScreenshot(driver);                        // capture full visible viewport

	    // Step 3: Save image
	    ImageIO.write(hoverShot.getImage(), "PNG",
	            new File(System.getProperty("user.dir") + "\\target\\HoverMenuScreenshot.png"));

	    System.out.println("✅ Hover menu (entire visible area) screenshot captured successfully!");
	}

	
	public String clickAndVerifyTitilePage() {
		scrollIntoViewJS(driver,menuTab);
		menuTab.click();
		scrollIntoViewJS(driver,menuTitle);
		return menuTitle.getText();
	}
	

}
