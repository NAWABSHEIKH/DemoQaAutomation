package com.demo.tests;

import com.demo.base.BaseDriver;
import com.demo.pages.DynamicPropertiesPage;
import com.demo.pages.RootPage;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicPropertiesTest extends BaseDriver {

    @Test
    public void verifyButtonBehaviour() {
        // Navigate to Dynamic Properties page via RootPage
        RootPage rp = new RootPage(driver);
        rp.clickElementTab();
        rp.clickDynamicProperties();

        DynamicPropertiesPage page = new DynamicPropertiesPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // increased timeout

        // Step 1: Enable button
        wait.until(ExpectedConditions.elementToBeClickable(page.getEnableButton()));
        Assert.assertTrue(page.getEnableButton().isEnabled(), "❌ Enable button did not become clickable!");
        System.out.println("✅ Enable button became clickable");

        // Step 2: Visible button
        wait.until(ExpectedConditions.visibilityOf(page.getVisibleButton()));
        Assert.assertTrue(page.getVisibleButton().isDisplayed(), "❌ Visible button did not appear!");
        System.out.println("✅ Visible button appeared");

        // Step 3: Color change button
        String expectedColor = "rgba(220, 53, 69, 1)"; // red color in rgba

        wait.until(driver -> {
            String currentColor = page.getColorChangeButton().getCssValue("color");
            return currentColor.equals(expectedColor);
        });

        String afterColor = page.getColorChangeButton().getCssValue("color");
        Assert.assertEquals(afterColor, expectedColor, "❌ Color did not change to red!");
        System.out.println("✅ Color change verified: " + afterColor);
    }
}
