package com.amlankumar.Actions;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragandDrop {

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
        String URL = "https://the-internet.herokuapp.com/drag_and_drop";
        driver.get(URL);

        WebElement from = driver.findElement(By.id("column-a"));
        WebElement to = driver.findElement(By.id("column-b"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(from,to).perform();
        /*
        OR(alt. method)
        actions.clickAndHold(from).moveToElement(to).release(to).build().perform();*/
        Thread.sleep(2000);


    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
