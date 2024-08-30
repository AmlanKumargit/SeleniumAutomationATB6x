package com.amlankumar.Actions;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUpload {

    // Atomic Test Cases
    // TC who don't have any dep.
    // They serve single purpose 0


    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }


    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testPositive() throws InterruptedException {
        driver.get("https://awesomeqa.com/selenium/upload.html");

        WebElement Uploadbtn = driver.findElement(By.id("fileToUpload"));
        WebElement submitbtn = driver.findElement(By.name("submit"));
        String dir = System.getProperty("user.dir");
        Uploadbtn.sendKeys(dir+"\\src\\test\\java\\com\\amlankumar\\Actions\\Upload.txt");
        /*
        OR(alt. method by providing absolute path with using dir)
        Uploadbtn.sendKeys("C:\\Users\\amlan\\IdeaProjects\\SeleniumAutomationATB6x\\src\\test\\java\\com\\amlankumar\\Actions\\Upload.txt"); */
        submitbtn.click();

        Thread.sleep(2000);


    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
