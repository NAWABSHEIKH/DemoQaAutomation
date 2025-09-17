package com.demo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicPropertiesPage {
    WebDriver driver;

    public DynamicPropertiesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(id = "enableAfter")
    WebElement btnEnable;

    @FindBy(id = "visibleAfter")
    WebElement btnVisibleAfter;

    @FindBy(id = "colorChange")
    WebElement colorChangeBtn;

    // --- Actions ---
    public boolean isEnableButtonInitiallyDisabled() {
        scrollIntoView(btnEnable);
        return btnEnable.isEnabled();
    }

    public WebElement getEnableButton() {
        return btnEnable;
    }

    public WebElement getVisibleButton() {
        return btnVisibleAfter;
    }

    public WebElement getColorChangeButton() {
        return colorChangeBtn;
    }

    public String getColorButtonClass() {
        return colorChangeBtn.getAttribute("class");
    }

    private void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
    }
}
