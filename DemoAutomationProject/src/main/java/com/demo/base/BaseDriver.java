package com.demo.base;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseDriver {

    public static WebDriver driver;
    public static String downloadDir;

    @BeforeMethod
    public void setup() {
        // Create custom download folder inside project
        downloadDir = System.getProperty("user.dir") + File.separator + "downloads";
        File folder = new File(downloadDir);
        if (!folder.exists()) {
            folder.mkdir();
        }

        // Configure Chrome to use our custom folder
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadDir);
        prefs.put("download.prompt_for_download", false); // no Save As dialog
        prefs.put("download.directory_upgrade", true);
        prefs.put("safebrowsing.enabled", true);
        prefs.put("plugins.always_open_pdf_externally", true); // force PDFs to download

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        // ✅ Pass options here
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
