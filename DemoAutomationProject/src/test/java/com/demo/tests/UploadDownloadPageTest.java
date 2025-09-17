package com.demo.tests;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.base.BaseDriver;
import com.demo.pages.RootPage;
import com.demo.pages.UploadDownloadPage;

public class UploadDownloadPageTest extends BaseDriver {
    
    @Test
    public void verifyUploadDownload() throws InterruptedException {
        // Navigate to Upload/Download page
        RootPage rp = new RootPage(driver);
        rp.clickElementTab();
        rp.clickUploadDownload();
        
        UploadDownloadPage updown = new UploadDownloadPage(driver);

        // ===== Upload part =====
        String fileLocation = "C:\\Users\\md786\\Downloads\\Hemant-Java-Dev.pdf";
        updown.uploadFile(fileLocation);

        Thread.sleep(2000);
        String actualMsg = updown.getUploadMessage();
        System.out.println("Upload message: " + actualMsg);

        Assert.assertTrue(actualMsg.contains("Hemant-Java-Dev.pdf"),
                "Your Upload file is not matched!");

        // ===== Download part =====
        updown.clickDownload();
        Thread.sleep(5000); // wait for file to download

        // DemoQA always downloads `sampleFile.jpeg`
        File downloadedFile = new File(downloadDir + File.separator + "sampleFile.jpeg");
        Assert.assertTrue(downloadedFile.exists(), "Download file not found in project folder!");

        System.out.println("File downloaded successfully at: " + downloadedFile.getAbsolutePath());
    }
}
