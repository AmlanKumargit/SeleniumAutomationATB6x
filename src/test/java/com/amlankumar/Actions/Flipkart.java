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

public class Flipkart {

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
        String URL = "https://www.flipkart.com/";
        driver.get(URL);
        driver.manage().window().maximize();



        Actions actions = new Actions(driver);
        Thread.sleep(2000);

        WebElement electronics = driver.findElement(By.xpath("//*[text()='Electronics']"));
        actions.moveToElement(electronics).build().perform();

        WebElement powerbank1 = driver.findElement(By.xpath("//a[@class='_1BJVlg _11MZbx']"));
        actions.moveToElement(powerbank1).build().perform();

        WebElement powerbank2 = driver.findElement(By.xpath("//a[normalize-space()='Powerbank']"));
        actions.moveToElement(powerbank2).click().build().perform();

        WebElement hightolow = driver.findElement(By.xpath("//div[text()='Price -- High to Low']"));
        hightolow.click();
        Thread.sleep(4000);

         List<WebElement> list = driver.findElements(By.xpath("//a[@class='wjcEIp']"));
        System.out.println("List of items from high to low:\n");
         for(int i=0;i<list.size();i++)
         {System.out.println("Item "+(i+1)+": "+ list.get(i).getText()+"\n");}

  /*      WebElement fname = driver.findElement(By.xpath("//a[@class='wjcEIp']"));
        System.out.println("First element's name: " + fname.getText());*/



    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
