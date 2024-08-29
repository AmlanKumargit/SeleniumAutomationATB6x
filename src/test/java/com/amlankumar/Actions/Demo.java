package com.amlankumar.Actions;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

    public class Demo {


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
            String URL = "https://awesomeqa.com/practice.html";
            driver.get(URL);
            driver.manage().window().maximize();

            // THETESTINGACADEMY
            // Shift Keydown -> thtestingacademy + Shift KeyUp

            WebElement firstName = driver.findElement(By.name("firstname"));
            WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));

            Actions actions = new Actions(driver);
            actions.keyDown(Keys.SHIFT).sendKeys(firstName,"amlan").keyUp(Keys.SHIFT).build().perform();
            actions.moveToElement(lastName).click().keyDown(Keys.SHIFT).sendKeys("kumar").keyUp(Keys.SHIFT).build().perform();


            Thread.sleep(2000);
            WebElement link = driver.findElement(By.xpath("//a[text()='Click here to Download File']"));
            actions.contextClick(link).build().perform();

            Thread.sleep(5000);

        }

        @AfterTest
        public void closeBrowser(){
            driver.quit();
        }
    }

