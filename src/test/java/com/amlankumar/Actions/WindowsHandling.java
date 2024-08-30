package com.amlankumar.Actions;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowsHandling {

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
        String URL = "https://the-internet.herokuapp.com/windows";
        driver.get(URL);
//        driver.manage().window().maximize();
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Before Clicking:\n"+mainWindowHandle);
        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();

        Set<String> windowHandles = driver.getWindowHandles(); // After clicking, 2 window handles appear so getWindowHandles()
        // All the Window handlers Tab have a unique string so stored in Set
        System.out.println("After clicking:");
        for (String handle : windowHandles){
            driver.switchTo().window(handle);
            System.out.println(handle);
            if(driver.getPageSource().contains("New Window")){
                System.out.println("\nTest case Passed\n");
            }
        }
        System.out.println("Current tab's title: "+driver.getTitle());
        driver.switchTo().window(mainWindowHandle);
        System.out.println("Tab's title post switching back to main tab: "+driver.getTitle());
        Thread.sleep(2000);


    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
